package com.spring.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class BookingDTO {
    private Integer id;
    private Integer userID;
    private Integer roomID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private int totalPrice;
}
