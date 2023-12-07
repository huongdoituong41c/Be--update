package com.spring.security.dto;

import lombok.Data;

@Data
public class HotelDTO {
    private Integer id;
    private String name;
    private String address;
    private String description;
    private byte[] img;
}
