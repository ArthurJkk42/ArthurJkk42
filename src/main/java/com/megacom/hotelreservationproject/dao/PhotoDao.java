package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Long> {

    @Query(value = "select a from Photo a where a.hotel = ?1")
    List<Photo> findAllPhotoByHotel(Hotel hotel);
}
