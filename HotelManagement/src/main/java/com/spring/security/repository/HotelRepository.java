package com.spring.security.repository;

import com.spring.security.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query(value = "SELECT DISTINCT A.id, A.name, A.address, A.description, A.img,  COUNT(DISTINCT C.ID) AS SL from HOTEL A \n" +
            "INNER JOIN ROOM_TABLE B ON A.ID = B.HOTEL_ID \n" +
            "INNER JOIN ROOM_TYPE C ON B.ROOM_TYPE_ID = C.ID\n" +
            "INNER JOIN BOOKING D ON D.ROOM_ID = B.ID\n" +
            "WHERE A.ADDRESS = :address\n" +
            "AND C.ID = :typeOfRoom\n" +
            "AND D.CHECK_IN_DATE = :checkInDate\n" +
            "AND D.CHECK_OUT_DATE  = :checkOutDate\n" +
            "AND B.AVAILABILITY = 1\n" +
            "GROUP BY A.id, A.name, A.address, A.description, A.img, C.ID", nativeQuery = true)
    List<Hotel> getHotel(String address, LocalDate checkInDate, LocalDate checkOutDate, int typeOfRoom);


    List<Hotel> findAll();

    Optional<Hotel> findById(Long id);

}
