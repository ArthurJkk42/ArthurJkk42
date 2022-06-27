package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.RoomCategoryDao;
import com.megacom.hotelreservationproject.mappers.RoomCategoryMapper;
import com.megacom.hotelreservationproject.models.dto.RoomCategoryDto;
import com.megacom.hotelreservationproject.models.entity.RoomCategory;
import com.megacom.hotelreservationproject.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryDao roomCategoryDao;

    private final RoomCategoryMapper roomCategoryMapper = RoomCategoryMapper.INSTANCE;

    @Override
    public RoomCategoryDto save(RoomCategoryDto roomCategoryDto) {
        RoomCategory roomCategory = roomCategoryMapper.roomCategoryDtoToRoomCategory(roomCategoryDto);
        RoomCategory savedRoomCategory = roomCategoryDao.save(roomCategory);
        return roomCategoryMapper.roomCategoryToRoomCategoryDto(savedRoomCategory);
    }

    @Override
    public RoomCategoryDto update(RoomCategoryDto roomCategoryDto) {
        RoomCategory roomCategory = roomCategoryMapper.roomCategoryDtoToRoomCategory(roomCategoryDto);
        RoomCategory updatedRoomCategory = roomCategoryDao.save(roomCategory);
        return roomCategoryMapper.roomCategoryToRoomCategoryDto(updatedRoomCategory);
    }
}
