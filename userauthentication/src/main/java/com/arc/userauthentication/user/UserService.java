package com.arc.userauthentication.user;

import com.arc.userauthentication.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void createVerificationToken(User user, String verificationToken);

    String validateToken(String verificationToken);
}
