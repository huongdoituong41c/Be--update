package com.spring.security.service;

import com.spring.security.dto.BookingDTO;
import com.spring.security.dto.HotelDTO;
import com.spring.security.dto.RoomTypeDTO;

import com.spring.security.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HotelService {
     @Autowired
     List<Hotel> getHotel(HotelDTO hotelDTO, BookingDTO bookingDTO, RoomTypeDTO roomTypeDTO);

     List <Hotel> findAll();

     Optional<Hotel> findById (Long id);

     void update(Long id, HotelDTO hotelDTO);
     void init ();
}
