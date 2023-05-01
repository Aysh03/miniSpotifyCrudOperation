package com.example.loginauthentication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found With this EmailID")
public class UserNotFoundException extends  Exception
{

}
