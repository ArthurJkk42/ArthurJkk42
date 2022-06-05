package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.RoomDto;

public interface RoomService {

    RoomDto save(RoomDto roomDto);

    RoomDto findById(Long id);

    RoomDto findByHotelId(RoomDto roomDto);

    RoomDto update(RoomDto roomDto);

    RoomDto delete(RoomDto roomDto);
}
