package com.example.loginauthentication.repository;

import com.example.loginauthentication.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAuthenticationRepository extends JpaRepository <UserData,String> {
 public abstract UserData  findByEmailIdAndPassword(String emailId,String password);

}
