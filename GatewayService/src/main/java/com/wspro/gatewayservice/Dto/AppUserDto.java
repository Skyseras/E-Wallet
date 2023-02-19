package com.wspro.gatewayservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUserDto implements Serializable {
    private Long id;
    private String lastName;
    private String firstName;
    private String cin;
    private String email;
    private String phone;
    private String password;
}
