package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.BookingDto;

import java.util.Date;

public interface BookingService {

    BookingDto save(BookingDto bookingDto);

    BookingDto findById(Long id);

    BookingDto findByHotelId(Long id);

    BookingDto findByRoomId(Long id);

    BookingDto findByGuestId(Long id);

    BookingDto findByCheckInDate(Date date);

    BookingDto findByCheckOutDate(Date date);

    BookingDto update(BookingDto bookingDto);

    BookingDto delete(BookingDto bookingDto);
}
