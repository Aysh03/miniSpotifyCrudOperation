package com.example.loginauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User with this Email ID Already Exist!!! Kindly Use any other Email ID ")
public class UserAlreadyExistException  extends Exception{

}
