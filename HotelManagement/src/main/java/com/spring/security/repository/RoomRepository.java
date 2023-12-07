package com.spring.security.repository;


import com.spring.security.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository  extends JpaRepository<Room,Integer>{
}
