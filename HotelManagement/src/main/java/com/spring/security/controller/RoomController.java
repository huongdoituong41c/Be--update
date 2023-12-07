package com.spring.security.controller;


import com.spring.security.dto.RoomDTO;
import com.spring.security.exception.BadRequestException;
import com.spring.security.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

//    @GetMapping("/{id}")
//    public RoomDTO findById(@PathVariable("id") int id) throws BadRequestException {
//        return this.roomService.findRoomById(id);
//    }
}
