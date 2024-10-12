package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class City extends BaseModel{
    private String name;
    private String pinCode;

    @OneToMany
    private List<Theatre> theatres;
}
