package com.example.loginauthentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupData
{
    private String emailId,userName,password,mobileNo,address,age;
}
