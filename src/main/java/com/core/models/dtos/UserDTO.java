package com.core.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String facebook;
}

