package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.BookingHistoryDto;
import com.megacom.hotelreservationproject.models.entity.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingHistoryDao extends JpaRepository<BookingHistory, Long> {

    @Query(value = "select * from tb_booking", nativeQuery = true)
    List<BookingHistoryDto> findAllBookingHistoryByBooking(BookingDto bookingDto);
}
