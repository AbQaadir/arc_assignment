package com.arc.userauthentication.user;

import com.arc.userauthentication.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    List<User> findByRole(String role);

    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void createVerificationToken(User user, String verificationToken);

    String validateToken(String verificationToken);

    User findByIdAndRole(Long id, String admin);
}
