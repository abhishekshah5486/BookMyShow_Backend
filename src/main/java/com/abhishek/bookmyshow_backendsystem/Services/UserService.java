package com.abhishek.bookmyshow_backendsystem.Services;

import com.abhishek.bookmyshow_backendsystem.Dtos.ResponseStatus;
import com.abhishek.bookmyshow_backendsystem.Models.User;

public interface UserService {
    User signUp(User user);
    ResponseStatus login(User user);
}
