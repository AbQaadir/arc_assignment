package com.arc.propertyms.property.external;

import lombok.*;

@Setter
@Getter
public class Admin {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String role;
    private Boolean isEnabled;
}
