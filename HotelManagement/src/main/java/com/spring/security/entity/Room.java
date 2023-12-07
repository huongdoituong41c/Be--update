package com.spring.security.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "room_table")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy ="room",  cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_TYPE_ID")
    private RoomType roomType;

    @OneToMany(mappedBy ="room",  cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @Column(name = "AVAILABILITY")
    private  boolean availability;

    @Column(name = "DESCRIPTION")
    private String description;
}
