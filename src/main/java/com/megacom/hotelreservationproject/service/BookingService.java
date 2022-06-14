package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.BookingDto;

import java.util.Date;
import java.util.List;

public interface BookingService {

    BookingDto bookByUser(BookingDto bookingDto); // required

    BookingDto bookByHotel(BookingDto bookingDto);

    BookingDto findById(Long id); // required

    BookingDto update(BookingDto bookingDto);

    BookingDto cancelBookingByOwner(BookingDto bookingDto);

    BookingDto cancelBookingByUser(BookingDto bookingDto);

    BookingDto findBookingByHotelId(Long id);

    BookingDto bookRoom(); // required

    BookingDto cancelBookingRoom(); // required

    BookingDto bookingEmailSender(); // required


    List<BookingDto> findAllBookingsByCheckOutDate(Date date);

    List<BookingDto> findAllBookingsByCheckInDate(Date date);

    List<BookingDto> findAllBookingsByGuestId(Long id);

    List<BookingDto> findAllBookingsByHotel(Long id);
}
