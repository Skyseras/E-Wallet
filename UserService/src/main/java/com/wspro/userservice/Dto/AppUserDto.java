package com.wspro.userservice.Dto;

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
    private String lastName;
    private String firstName;
    private String cin;
    private String email;
    private String phone;
    private String password;
}
