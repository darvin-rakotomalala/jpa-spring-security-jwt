package com.poc.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SignupRequestDTO {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
