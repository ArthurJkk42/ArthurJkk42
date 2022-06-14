package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

//    @Query(value = "")
//    List<BookingDto> findAllBookingsByCheckOutDate(Date date);
//
//    @Query(value = "")
//    List<BookingDto> findAllBookingsByCheckInDate(Date date);
//
//    @Query(value = "")
//    List<BookingDto> findAllBookingsByGuestId(Long id);
//
//    @Query(value = "")
//    List<BookingDto> findAllBookingsByHotel(Long id);
}
