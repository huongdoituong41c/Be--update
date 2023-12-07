package com.spring.security.controller;

import com.spring.security.dto.BookingDTO;
import com.spring.security.dto.HotelDTO;
import com.spring.security.dto.RoomTypeDTO;
import com.spring.security.entity.Hotel;
import com.spring.security.exception.NotFoundException;
import com.spring.security.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            List<Hotel> getAllHotel = this.hotelService.findAll();
            if(getAllHotel.isEmpty()) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not Found");
            } else {
                return ResponseEntity.ok(getAllHotel);
            }
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/getHotel/{address}/{id}")
    public ResponseEntity<?> getHotel(@RequestBody BookingDTO bookingDTO, @PathVariable("address")String address, @PathVariable("id")Integer roomType) {
        HotelDTO hotelDTO = new HotelDTO();
        RoomTypeDTO roomTypeDTO = new RoomTypeDTO();
        try{
            hotelDTO.setAddress(address);
            roomTypeDTO.setId(roomType);
            List<Hotel> hotels = this.hotelService.getHotel(hotelDTO, bookingDTO, roomTypeDTO);
            if (hotels.isEmpty()) {
                return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The rooms aren't available");
            } else {
                return ResponseEntity.ok(hotels);
            }
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getHotelById(@PathVariable Long id) {

          Optional<Hotel> hotel = this.hotelService.findById(id);
          if (hotel.isPresent()) {
              return ResponseEntity.ok(hotel.get());
          } else {
              throw new NotFoundException("Hotel not found with id= "+id);
          }
    }

    @PutMapping("update/{id}")
    public void updateHotelById(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        this.hotelService.update(id, hotelDTO);
    }

}
