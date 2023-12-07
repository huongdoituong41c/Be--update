package com.spring.security.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "room_type")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy ="roomType",  cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @Column(name = "TYPE_NAME", nullable = false)
    private String typeName;

    @Column(name="PRICE_PER_NIGHT", nullable = false)
    private int pricePerNight;

}
