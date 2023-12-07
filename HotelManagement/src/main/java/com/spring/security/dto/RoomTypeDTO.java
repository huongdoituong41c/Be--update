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
public class RoomTypeDTO {
    private Integer id;
    private List<Booking> bookings = new ArrayList<>();
    private Hotel hotel;
    private RoomType roomType;
    private List<Image> images = new ArrayList<>();
    private  boolean availability;
    private String description;
}
