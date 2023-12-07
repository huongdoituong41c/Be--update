package com.spring.security.dto;

import com.spring.security.entity.Booking;
import com.spring.security.entity.Hotel;
import com.spring.security.entity.Image;
import com.spring.security.entity.RoomType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDTO {
    private Integer id;
    private int hotelId;
    private Integer[] bookingId;
    private boolean availability;
    private String description;
}
