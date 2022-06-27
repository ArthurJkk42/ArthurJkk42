package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.RoomDto;
import com.megacom.hotelreservationproject.models.enums.EBedType;

import java.util.List;

public interface RoomService {

    RoomDto save(RoomDto roomDto);

    RoomDto findById(Long id);

    RoomDto update(RoomDto roomDto);

    List<RoomDto> filterByBedType(EBedType eBedType); // required

    List<RoomDto> findByBooking(Long id);

    List<RoomDto> findByHotelId(Long id);

    List<RoomDto> findByHotelGuestId(Long id);


}
