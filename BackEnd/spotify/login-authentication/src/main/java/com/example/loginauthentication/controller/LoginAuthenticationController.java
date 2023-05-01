package com.example.loginauthentication.controller;

import com.example.loginauthentication.exception.UserAlreadyExistException;
import com.example.loginauthentication.exception.UserNotFoundException;
import com.example.loginauthentication.model.SignupData;
import com.example.loginauthentication.model.UserData;
import com.example.loginauthentication.service.LoginAuthenticationService;
import com.example.loginauthentication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth-app")
public class LoginAuthenticationController
{





        @Autowired
        LoginAuthenticationService loginAuthenticationService;


        @Autowired
        private SecurityTokenGenerator securityTokenGenerator;

        //http://localhost:4444/auth-app/register-user [post]

//        @PostMapping("/register-user")
//        public ResponseEntity<?> registerUser(@RequestBody UserData userData) throws UserAlreadyExistException {
//            try {
//                userData.setRole("Role_User");
//                return new ResponseEntity<>(loginAuthenticationService.registerUser(userData),HttpStatus.OK);
//            }
//           catch(UserAlreadyExistException ex)
//           {
//               throw new UserAlreadyExistException();
//           }
//        }


        @PostMapping("/register-user1")
        public ResponseEntity<?> registerUser1(@RequestBody SignupData signupData) {
            return new ResponseEntity<>(loginAuthenticationService.registrationUser1(signupData), HttpStatus.OK);
        }


//        @PostMapping("/login-check")
//
//        public ResponseEntity<?> loginCheck(@RequestBody UserData userData) throws UserNotFoundException {
//
//            try {
//                UserData res = loginAuthenticationService.loginCheck(userData);
//
//                if (res != null) {
//                    return new ResponseEntity<>(securityTokenGenerator.generateToken(res), HttpStatus.OK);
//                }
//            } catch (UserNotFoundException ux) {
//
//
//                throw new UserNotFoundException();
//            }
//            return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
//        }
//
//        }


        @PostMapping("/login-check")
        public ResponseEntity<?> loginCheck(@RequestBody UserData user)
        {
            UserData res = loginAuthenticationService.loginCheck(user);
            if (res != null) {
                return new ResponseEntity<>(securityTokenGenerator.generateToken(res), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Authentication failed", HttpStatus.OK);
            }
        }










    }














