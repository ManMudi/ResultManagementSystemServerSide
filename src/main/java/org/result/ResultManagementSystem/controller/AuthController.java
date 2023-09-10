package org.result.ResultManagementSystem.controller;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.LoginDto;
import org.result.ResultManagementSystem.dto.RegisterDto;
import org.result.ResultManagementSystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
   //REGISTER REST API
    @PostMapping("/register")
    ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String s=authService.register(registerDto);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    //LOGIN REST API
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response=authService.login(loginDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
