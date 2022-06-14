package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.PriceDto;

import java.util.List;

public interface PriceService {

    PriceDto save(PriceDto priceDto);

    PriceDto findById(Long id);

    PriceDto findByRoomId(Long id);

    PriceDto findByGuestId(Long id);

    PriceDto update(PriceDto priceDto);

    List<PriceDto> findPricesByHotel(Long id);

    List<PriceDto> findPricesByCity();
}
