package org.result.ResultManagementSystem.repository;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@AllArgsConstructor
public class UserRepositoryTest {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Test
    void saveUser(){

        Users users=new Users();
        users.setName("Zaiman");
        users.setEmail("zaiman@gmail.com");
        users.setUsername("zaiman");
        users.setPassword(("1234"));

        Role admin=new Role();
        admin.setName("ADMIN");

        users.getRoles().add(admin);

        userRepository.save(users);


    }


}