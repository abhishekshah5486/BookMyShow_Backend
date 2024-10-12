package com.abhishek.bookmyshow_backendsystem.Services;

import com.abhishek.bookmyshow_backendsystem.Dtos.ResponseStatus;
import com.abhishek.bookmyshow_backendsystem.Models.User;
import com.abhishek.bookmyshow_backendsystem.Repositories.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
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
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());

        return userRepository.save(newUser);
    }

    @Override
    public ResponseStatus login(User user) {
        // Validate if the email is registered
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if (optionalUser.isEmpty()){
            return ResponseStatus.ACCOUNT_NOT_REGISTERED;
        }
        // Validate the password
        if (user.getPassword().equals(optionalUser.get().getPassword())){
            return ResponseStatus.SUCCESS;
        }
        return ResponseStatus.INVALID_PASSWORD;
    }
}
