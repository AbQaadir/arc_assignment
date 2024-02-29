package com.arc.userauthentication.user;


import com.arc.userauthentication.dto.AdminDTO;
import com.arc.userauthentication.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        return userService.getUsers().stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


    @GetMapping("/admin")
    public List<AdminDTO> getAllAdmins() {
        return userService.findByRole("ADMIN").stream()
                .map(this::convertToAdminDTO)
                .collect(Collectors.toList());
    }

    private AdminDTO convertToAdminDTO(User user) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(user.getId());
        adminDTO.setFirstname(user.getFirstname());
        adminDTO.setLastname(user.getLastname());
        adminDTO.setEmail(user.getEmail());
        adminDTO.setRole(user.getRole());
        return adminDTO;
    }

    @GetMapping("/admin/{id}")
    public AdminDTO getAdminById(@PathVariable Long id) {
        User admin = userService.findByIdAndRole(id, "ADMIN");
        return convertToAdminDTO(admin);
    }
}
