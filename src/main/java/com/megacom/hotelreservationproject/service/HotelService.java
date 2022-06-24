package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface HotelService {

    HotelDto save(HotelDto hotelDto);

    HotelDto findById(Long id);

    HotelDto update(HotelDto hotelDto);

    HotelDto setActive(HotelDto hotelDto);

    HotelDto delete(HotelDto hotelDto); // required

    HotelDto block(HotelDto hotelDto); // required

    HotelDto findHotelByUser(Long id);

    void countCurrentScore(); // required

    List<HotelDto> findAllHotels(); // required

    ResponseEntity<?> findHotelsByCityIdAndRating(Long cityId); // required

    ResponseEntity<?> filterByCity(Long cityId,
                                   Date checkInDate, Date checkOutDate,
                                   int guestCount, int roomCount);

    List<HotelDto> findConvenientHotelsByDate(Date CheckInDate, Date checkOutDate); // required

    List<HotelDto> findConvenientHotelsByGuestsAmount(Long guestAmount); //required

    List<HotelDto> findFreeRoomsAmountByHotel(HotelDto hotelDto); // required

    List<HotelDto> filterHotelsByRatings(double score); // required


}
