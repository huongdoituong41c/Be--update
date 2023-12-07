package com.spring.security.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@Table(name = "BOOKING")

public class Booking {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @Column(name = "CHECK_IN_DATE", nullable = false)
    private  LocalDate checkInDate;

    @Column(name = "CHECK_OUT_DATE", nullable = true)
    private  LocalDate checkOutDate;

    @Column(name = "NUMBER_OF_GUESTS", nullable = false )
    private int numberOfGuests;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private int totalPrice;

    @Column(name = "CONFIRMATION_STATUS", nullable = false)
    private String confirmationStatus;
}
