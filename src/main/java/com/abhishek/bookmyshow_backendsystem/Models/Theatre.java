package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theatre extends BaseModel{
    private String theatreName;
    private String address;

    @ManyToOne
    private City city;
    @OneToMany
    private List<Screen> screens;
    private Double rating;
}