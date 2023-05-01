package com.example.loginauthentication.service;

import com.example.loginauthentication.exception.UserAlreadyExistException;
import com.example.loginauthentication.exception.UserNotFoundException;
import com.example.loginauthentication.model.SignupData;
import com.example.loginauthentication.model.UserDTO;
import com.example.loginauthentication.model.UserData;
import com.example.loginauthentication.proxy.Loginproxy;
import com.example.loginauthentication.repository.LoginAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationServiceImpl implements LoginAuthenticationService

{
    @Autowired
    LoginAuthenticationRepository loginAuthenticationRepository;


    @Autowired
    Loginproxy loginproxy;

//    @Override
//    public UserData registerUser(UserData userData) throws UserAlreadyExistException {
//
//
//        if (loginAuthenticationRepository.findById(userData.getEmailId()).isEmpty()) {
//            return loginAuthenticationRepository.save(userData);
//        }
//        else {
//            throw new UserAlreadyExistException();
//        }
//    }
//
//    @Override
//    public UserData loginCheck(UserData userData) throws UserNotFoundException
//    {
//
//        if (loginAuthenticationRepository.findById(userData.getEmailId()).isPresent()) {
//            UserData res = loginAuthenticationRepository.findById(userData.getEmailId()).get();
//
//            if (res.getPassword().equals(userData.getPassword())) {
//                return res;
//            } else {
//                throw new UserNotFoundException();
//            }
//        } else {
//            throw new UserNotFoundException();
//        }
//    }
//

// LoginController.java

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
//        String username = request.getUsername();
//        String password = request.getPassword();
//
//        User user = userService.findByUsername(username);
//        if (user == null) {
//            throw new UserNotFoundException("User not found.");
//        }
//
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new PasswordNotCorrectException("Password not correct.");
//        }
//
//        // Generate token and set role
//        String token = jwtProvider.generateToken(username);
//
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }







//// login.component.ts
//
//    onSubmit() {
//        this.authService.login(this.username, this.password)
//                .subscribe(
//                        (data) => {
//                this.router.navigate(['/home']);
//            },
//        (error) => {
//            if (error instanceof HttpErrorResponse) {
//                if (error.status === 401) {
//                    this.errorMessage = 'Invalid credentials.';
//                } else if (error.status === 404) {
//                    this.errorMessage = 'User not found.';
//                } else if (error.status === 409) {
//                    this.errorMessage = 'User id already exists.';
//                }
//            }
//        }
//        );
//    }



















    @Override
    public UserData registrationUser1(SignupData signupData) {
        UserDTO userDTO=new UserDTO(signupData.getEmailId(),signupData.getUserName(), signupData.getMobileNo(),signupData.getAge(), signupData.getAddress());
        ResponseEntity response= loginproxy.sendUserDtoToProductApp(userDTO);
        System.out.println(response);

        UserData user = new UserData(signupData.getEmailId(), signupData.getPassword(), "ROLE_USER");
        System.out.println(user);
        return loginAuthenticationRepository.save(user);
    }



    @Override
    public UserData loginCheck(UserData userData)
    {

        if (loginAuthenticationRepository.findById(userData.getEmailId()).isPresent()) {
            UserData res = loginAuthenticationRepository.findById(userData.getEmailId()).get();

            if (res.getPassword().equals(userData.getPassword())) {
                return res;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }





}
