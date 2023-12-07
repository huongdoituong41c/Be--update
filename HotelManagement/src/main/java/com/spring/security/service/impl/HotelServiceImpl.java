package com.spring.security.service.impl;

import com.spring.security.dto.BookingDTO;
import com.spring.security.dto.HotelDTO;
import com.spring.security.dto.RoomTypeDTO;

import com.spring.security.entity.Hotel;
import com.spring.security.exception.NotFoundException;
import com.spring.security.repository.HotelRepository;
import com.spring.security.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    private final Path uploadDir = Paths.get("uploads");
    public List<Hotel> getHotel(HotelDTO hotelDTO, BookingDTO bookingDTO, RoomTypeDTO roomTypeDTO) {
        return this.hotelRepository.getHotel(hotelDTO.getAddress(),bookingDTO.getCheckInDate(),bookingDTO.getCheckOutDate(), roomTypeDTO.getId());
    }

    @Override
    public List<Hotel> findAll() {
        return this.hotelRepository.findAll();
    }

    public Optional<Hotel> findById (Long id)
    {return this.hotelRepository.findById(id);}

    @Override
    public void update(Long id, HotelDTO hotelDTO) {
        Optional<Hotel> hotel = this.hotelRepository.findById(id);
        if(hotel.isPresent()) {
            throw new NotFoundException("Not found hotel");
        };

        hotel.get().setName(hotelDTO.getName());
        hotel.get().setAddress(hotelDTO.getAddress());
        hotel.get().setDescription(hotelDTO.getDescription());

        this.hotelRepository.save(hotel.get());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(uploadDir);
        } catch (Exception e) {

        }
    }
}
