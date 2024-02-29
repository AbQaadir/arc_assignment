package com.arc.userauthentication.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
