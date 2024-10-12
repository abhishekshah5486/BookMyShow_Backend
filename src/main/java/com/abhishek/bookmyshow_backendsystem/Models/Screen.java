package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.*;
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
public class Screen extends BaseModel{
    private String name;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;

    @ManyToOne
    private Theatre theatre;
}
