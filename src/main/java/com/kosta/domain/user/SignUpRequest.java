package com.kosta.domain.user;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignUpRequest {
    private String email;
    private String name;
    private String password;
}
