
package org.result.ResultManagementSystem.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@AllArgsConstructor
@EnableMethodSecurity
@Configuration
public class SpringSecurityConfig {
    private UserDetailsService userDetailsService;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeHttpRequests((authorize)->{
/*
            authorize.requestMatchers(HttpMethod.POST,"/students/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/students/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/students/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/exams/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/exams/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/exams/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/exams/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/levels/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/levels/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/levels/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/levels/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/marks/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/marks/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/marks/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/marks/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/subjects/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/subjects/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/subjects/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/subjects/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/terms/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/terms/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/terms/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/terms/**").hasAnyRole("ADMIN","USER");

            authorize.requestMatchers(HttpMethod.POST,"/years/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.PUT,"/years/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.DELETE,"/terms/**").hasRole("ADMIN");
            authorize.requestMatchers(HttpMethod.GET,"/terms/**").hasAnyRole("ADMIN","USER");

*/
            authorize.requestMatchers(HttpMethod.POST,"/auth/**").permitAll();
           // authorize.requestMatchers(HttpMethod.POST,"/roles/**").hasRole("ADMIN");
          //  authorize.requestMatchers(HttpMethod.GET,"/auth/login/**").hasAnyRole("ADMIN","USER");

            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }
   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public UserDetailsService userDetailService(){
        UserDetails mohamed= User.builder().username("mohamed").password(passwordEncoder().encode("1234")).roles("USER").build();
        UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(mohamed,admin);

    }
}
