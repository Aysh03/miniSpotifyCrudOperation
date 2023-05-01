package com.example.loginauthentication.service;

import com.example.loginauthentication.exception.UserAlreadyExistException;
import com.example.loginauthentication.exception.UserNotFoundException;
import com.example.loginauthentication.model.SignupData;
import com.example.loginauthentication.model.UserData;

public interface LoginAuthenticationService
{

    public abstract UserData registrationUser1(SignupData signupData);
    public abstract UserData loginCheck(UserData user);


}
