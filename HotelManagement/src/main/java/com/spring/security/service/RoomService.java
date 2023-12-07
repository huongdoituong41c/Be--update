package com.spring.security.service;

import com.spring.security.dto.RoomDTO;
import com.spring.security.entity.Room;
import com.spring.security.exception.BadRequestException;

import java.util.List;

public interface RoomService {
    RoomDTO findRoomById(int id) throws BadRequestException;
}
