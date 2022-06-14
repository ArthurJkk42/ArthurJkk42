package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<Hotel, Long> {

//    @Query(value = "")
//    List<String> uploadHotelPhotos(); // required

    @Query(value = "select * from tb_hotel a where a.city_id = ?1", nativeQuery = true)
    List<Hotel> findHotelsByCityId(Long cityId); // required

    @Query(value = "select * from tb_hotel a where a.current_score", nativeQuery = true)
    List<Hotel> findHotelsByRating(double scoreInput); // required

//    @Query(value = "")
//    List<Hotel> findConvenientHotelsByDate(Date CheckInDate, Date checkOutDate); // required
//
//    @Query(value = "")
//    List<Hotel> findConvenientHotelsByGuestsAmount(Long guestAmount); //required
//
//    @Query(value = "")
//    List<Hotel> findFreeRoomsAmountByHotel(HotelDto hotelDto); // required
//
//    @Query(value = "")
//    List<Hotel> filterHotelsByRatings(double score); // required
}
