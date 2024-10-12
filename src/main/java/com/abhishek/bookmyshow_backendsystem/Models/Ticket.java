package com.abhishek.bookmyshow_backendsystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket extends BaseModel {
    private Long bookingId;
    private Date timeStamp;
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> showSeatList;
    @ManyToOne
    private Movie movie;
    @OneToOne
    private Payment payment;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    private Double pricePerTicket;
    private Double totalAmount;
    private Integer quantity;
}
