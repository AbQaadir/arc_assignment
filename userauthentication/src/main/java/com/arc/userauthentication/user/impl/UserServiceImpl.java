package com.arc.userauthentication.user.impl;

import com.arc.userauthentication.exception.UserAlreadyExistsException;
import com.arc.userauthentication.registration.RegistrationRequest;
import com.arc.userauthentication.registration.token.VerificationToken;
import com.arc.userauthentication.registration.token.VerificationTokenRepository;
import com.arc.userauthentication.user.User;
import com.arc.userauthentication.user.UserRepository;
import com.arc.userauthentication.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User findByIdAndRole(Long id, String role) {
        User user =  userRepository.findByIdAndRole(id, role);

        if (user == null) {

        }
        return user;
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.email());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + request.email() + " already exists");
        }

        User newUser = new User();

        newUser.setFirstname(request.firstname());
        newUser.setLastname(request.lastname());
        newUser.setEmail(request.email());
        newUser.setPassword(bCryptPasswordEncoder.encode(request.password()));
        newUser.setRole(request.role());
        newUser.setIsEnabled(false);

        return userRepository.save(newUser);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        var verificationToken = new VerificationToken(token, user);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String verificationToken) {
        var token = verificationTokenRepository.findByToken(verificationToken);
        if (token == null) {
            return "Invalid Token";
        }

        User user = token.getUser();

        // check if token is expired
        if (token.getExpiryDate().getTime() - System.currentTimeMillis() <= 0) {
            verificationTokenRepository.delete(token);
            return "Token expired";
        }

        user.setIsEnabled(true);
        userRepository.save(user);
        return "valid";
    }
}
