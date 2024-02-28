package com.arc.userauthentication.event.listener;

import com.arc.userauthentication.event.RegistrationCompleteEvent;
import com.arc.userauthentication.user.User;
import com.arc.userauthentication.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {


        // get new user from event
        User user = event.getUser();

        // create a verification Token
        String verificationToken = UUID.randomUUID().toString();

        // save the verification token
        userService.createVerificationToken(user, verificationToken);


        // build the verification link
        String url = event.getAppUrl() + "/register/verifyEmail?token=" + verificationToken;

        // send the verification link
        log.info("Verification link: " + url);

    }


}
