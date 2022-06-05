package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.PriceDto;

public interface PriceService {

    PriceDto save(PriceDto priceDto);

    PriceDto findById(Long id);

    PriceDto findByRoomId(Long id);

    PriceDto update(PriceDto priceDto);

    PriceDto delete(PriceDto priceDto);
}
