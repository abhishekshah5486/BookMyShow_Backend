package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Seat extends BaseModel{
    private String seatName;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private Integer colNum;
    private Integer rowNum;

    @ManyToOne
    private Screen screen;
}
