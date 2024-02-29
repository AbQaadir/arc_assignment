package com.arc.userauthentication.user;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/admin")
    public List<User> getAllAdmins() {
        return userService.findByRole("ADMIN");
    }

    @GetMapping("/admin/{id}")
    public User getAdminById(@PathVariable Long id) {
        return userService.findByIdAndRole(id, "ADMIN");
    }
}
