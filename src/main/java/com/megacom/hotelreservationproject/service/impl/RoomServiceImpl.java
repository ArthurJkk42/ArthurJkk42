package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.RoomDao;
import com.megacom.hotelreservationproject.mappers.RoomMapper;
import com.megacom.hotelreservationproject.models.dto.RoomDto;
import com.megacom.hotelreservationproject.models.entity.Room;
import com.megacom.hotelreservationproject.models.enums.EBedType;
import com.megacom.hotelreservationproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    private RoomMapper roomMapper = RoomMapper.INSTANCE;

    @Override
    public RoomDto save(RoomDto roomDto) {
        Room room = roomMapper.roomDtoToRoom(roomDto);
        Room roomSaved = roomDao.save(room);
        return roomMapper.roomToRoomDto(roomSaved);
    }

    @Override
    public RoomDto findById(Long id) {
        Room room = roomDao.findById(id).orElse(null);
        return roomMapper.roomToRoomDto(room);
    }

    @Override
    public RoomDto update(RoomDto roomDto) {
        return null;
    }

    @Override
    public List<RoomDto> filterByBedType(EBedType eBedType) {
        return null;
    }

    @Override
    public List<RoomDto> findByBooking(Long id) {
        return null;
    }

    @Override
    public List<RoomDto> findByHotelId(Long id) {
        return null;
    }

    @Override
    public List<RoomDto> findByHotelGuestId(Long id) {
        return null;
    }
}