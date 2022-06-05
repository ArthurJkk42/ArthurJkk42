package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.BookingHistoryDto;

public interface BookingHistoryService {

    BookingHistoryDto save(BookingHistoryDto bookingHistoryDto);

    BookingHistoryDto findById(Long id);

    BookingHistoryDto update(BookingHistoryDto bookingHistoryDto);

    BookingHistoryDto delete(BookingHistoryDto bookingHistoryDto);


}
