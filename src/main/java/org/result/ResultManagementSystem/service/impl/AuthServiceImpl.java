package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.dto.LoginDto;
import org.result.ResultManagementSystem.dto.RegisterDto;
import org.result.ResultManagementSystem.entity.Role;
import org.result.ResultManagementSystem.entity.Users;
import org.result.ResultManagementSystem.exception.ResourceNotFoundException2;
import org.result.ResultManagementSystem.repository.RoleRepository;
import org.result.ResultManagementSystem.repository.UserRepository;
import org.result.ResultManagementSystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    @Override
    public String register(RegisterDto registerDto) {

        //Check Username is already exist
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new ResourceNotFoundException2(HttpStatus.BAD_REQUEST,"Username Already Exists !");
        }

        //Check Email
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new ResourceNotFoundException2(HttpStatus.BAD_REQUEST,"Email Already Exist !");
        }
        Role user=roleRepository.findByName("USER");

        Users users=new Users();
        users.setName(registerDto.getName());
        users.setEmail(registerDto.getEmail());
        users.setUsername(registerDto.getUsername());
        users.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        users.getRoles().add(user);

        userRepository.save(users);

        return "User registered Successfully !";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User Logged in Successfully !";
    }
}
