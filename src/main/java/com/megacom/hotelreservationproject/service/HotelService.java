package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.HotelDto;

public interface HotelService {

    HotelDto save(HotelDto hotelDto);

    HotelDto findById(HotelDto hotelDto);

    HotelDto findByCity(Long id);

    HotelDto update(HotelDto hotelDto);

    HotelDto delete(HotelDto hotelDto);
}
