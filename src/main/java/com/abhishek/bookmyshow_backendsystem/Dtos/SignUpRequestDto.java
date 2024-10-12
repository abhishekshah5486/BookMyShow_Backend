package com.abhishek.bookmyshow_backendsystem.Dtos;

import com.abhishek.bookmyshow_backendsystem.Models.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto{
    private String username;
    private String name;
    private String email;
    private String password;
}
