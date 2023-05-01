package com.example.loginauthentication.service;

import com.example.loginauthentication.model.UserData;
import org.springframework.stereotype.Service;

import java.util.Map;



public interface SecurityTokenGenerator
{
public abstract Map<String,String> generateToken(UserData userData);




}
