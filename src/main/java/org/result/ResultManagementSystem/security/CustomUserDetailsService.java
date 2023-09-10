package org.result.ResultManagementSystem.security;

import lombok.AllArgsConstructor;
import org.result.ResultManagementSystem.entity.Users;
import org.result.ResultManagementSystem.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Users users=userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(
                ()->new UsernameNotFoundException("User Not Exists By Username or Email"));
        Set<GrantedAuthority> grantedAuthorities=users.getRoles().stream().map(
                (role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        return new User(
                usernameOrEmail,
                users.getPassword(),
                grantedAuthorities
        );
    }
}
