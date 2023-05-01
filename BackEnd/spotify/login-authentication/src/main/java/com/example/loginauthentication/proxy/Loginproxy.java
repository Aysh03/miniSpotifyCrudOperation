package com.example.loginauthentication.proxy;

import com.example.loginauthentication.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name="track-service",url="localhost:24242")
public interface Loginproxy
{
    @PostMapping("/track-app/add-user")
    public abstract ResponseEntity<?> sendUserDtoToProductApp(@RequestBody UserDTO userDTO);

}
