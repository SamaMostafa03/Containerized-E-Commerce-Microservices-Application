package com.sama.E_Commerce.controller;

import com.sama.E_Commerce.model.User;
import com.sama.E_Commerce.service.JwtService;
import com.sama.E_Commerce.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return new ResponseEntity<>(jwtService.generateToken(user.getUsername()) , HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
