package com.revature.security.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest{

    private String username;
    private String password;
}
