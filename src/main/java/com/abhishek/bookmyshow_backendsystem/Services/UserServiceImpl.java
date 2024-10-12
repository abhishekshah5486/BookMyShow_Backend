package com.abhishek.bookmyshow_backendsystem.Services;

import com.abhishek.bookmyshow_backendsystem.Models.User;
import com.abhishek.bookmyshow_backendsystem.Repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(User user) {
        // Check if the user is already registered with email id
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            // Redirect to the login page
            return optionalUser.get();
        }
        // Create a new user
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(encodedPassword);
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());

        return userRepository.save(newUser);
    }
}
