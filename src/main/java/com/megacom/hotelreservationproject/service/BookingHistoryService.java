package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.BookingHistoryDto;

import java.util.List;

public interface BookingHistoryService {

    BookingHistoryDto save(BookingHistoryDto bookingHistoryDto);

    BookingHistoryDto findById(Long id);

    List<BookingHistoryDto> findAllBookingHistoryByBooking(BookingDto bookingDto);
}
