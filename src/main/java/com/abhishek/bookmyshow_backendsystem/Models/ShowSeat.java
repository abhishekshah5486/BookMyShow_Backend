package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;
    private ShowSeatStatus showSeatStatus;
}
