package com.spring.security.service.impl;

import com.spring.security.dto.RoomDTO;
import com.spring.security.entity.Booking;
import com.spring.security.entity.Room;
import com.spring.security.enumeration.EApplicationError;
import com.spring.security.exception.BadRequestException;
import com.spring.security.repository.RoomRepository;
import com.spring.security.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RoomDTO findRoomById(int id)  throws BadRequestException  {
        Optional<Room> room = roomRepository.findById(id);
        RoomDTO roomDTO = new RoomDTO();

        if(!room.isPresent()){
            throw new BadRequestException(EApplicationError.ROOM_NOT_FOUND.getErrorObject());
        }else {
            List<Booking> bookings = room.get().getBookings();
            roomDTO = this.modelMapper.map(room.get(), RoomDTO.class);
            roomDTO.setHotelId(room.get().getHotel().getId());
            roomDTO.setBookingId((Integer[]) bookings.stream().map(Booking::getId).toArray());
        }
        return roomDTO;
    }
}
