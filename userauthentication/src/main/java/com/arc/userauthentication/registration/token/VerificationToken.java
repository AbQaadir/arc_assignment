package com.arc.userauthentication.registration.token;

import com.arc.userauthentication.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "verification_token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expiryDate;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationToken(String token) {
        super();
        this.token = token;
        this.expiryDate = new Date(new Date().getTime() + 1000 * 60 * 24);
    }

    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.expiryDate = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
        this.user = user;
    }

}
