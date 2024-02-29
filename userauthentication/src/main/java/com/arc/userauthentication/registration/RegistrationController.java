package com.arc.userauthentication.registration;


import com.arc.userauthentication.event.RegistrationCompleteEvent;
import com.arc.userauthentication.registration.token.VerificationToken;
import com.arc.userauthentication.registration.token.VerificationTokenRepository;
import com.arc.userauthentication.user.User;
import com.arc.userauthentication.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/register")
public class RegistrationController {

    private final UserService userService;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final VerificationTokenRepository verificationTokenRepository;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request, final HttpServletRequest httpServletRequest) {
        User user = userService.registerUser(request);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, appUrl(httpServletRequest)));
        return "Registered successfully";
    }


    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken.getUser().getIsEnabled()) {
            return "Email already verified. Please login.";
        }

        String verificationResult = userService.validateToken(token);

        if (verificationResult.equals("valid")) {
            return "Email verified successfully. Please login.";
        } else {
            return "Invalid token";
        }
    }

    private String appUrl(HttpServletRequest httpServletRequest) {
        return "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
    }

}
