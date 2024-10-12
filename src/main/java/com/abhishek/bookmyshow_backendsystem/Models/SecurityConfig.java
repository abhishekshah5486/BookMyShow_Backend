package com.abhishek.bookmyshow_backendsystem.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
// This annotation tells spring that this class has 1 or more bean methods
public class SecurityConfig {
    private int saltRounds = 10;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(saltRounds);
    }
}
