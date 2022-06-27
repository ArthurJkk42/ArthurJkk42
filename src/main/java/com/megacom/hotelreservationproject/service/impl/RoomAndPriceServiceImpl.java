package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.PriceDao;
import com.megacom.hotelreservationproject.dao.RoomCategoryDao;
import com.megacom.hotelreservationproject.dao.RoomDao;
import com.megacom.hotelreservationproject.models.dto.PriceDto;
import com.megacom.hotelreservationproject.models.dto.RoomCategoryDto;
import com.megacom.hotelreservationproject.models.entity.RoomCategory;
import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequest;
import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequestWithId;
import com.megacom.hotelreservationproject.service.PriceService;
import com.megacom.hotelreservationproject.service.RoomAndPriceService;
import com.megacom.hotelreservationproject.service.RoomCategoryService;
import com.megacom.hotelreservationproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomAndPriceServiceImpl implements RoomAndPriceService {

    @Autowired
    private RoomCategoryService roomCategoryService;
    @Autowired
    private RoomCategoryDao roomCategoryDao;
    @Autowired
    private PriceDao priceDao;
    @Autowired
    private PriceService priceService;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomService roomService;

    @Override
    public List<Object> save(RoomCategoryAndPriceRequest roomAndPriceRequest) {
        RoomCategoryDto roomCategoryDto = new RoomCategoryDto();
        PriceDto priceDto = new PriceDto();

        roomCategoryDto.setRoomType(roomAndPriceRequest.getRoomType());

        RoomCategoryDto savedCat = roomCategoryService.save(roomCategoryDto);

        priceDto.setPrice(roomAndPriceRequest.getPrice());
        priceDto.setStartDate(roomAndPriceRequest.getStartDate());
        priceDto.setEndDate(roomAndPriceRequest.getEndDate());
        priceDto.setRoomCategory(savedCat);

        PriceDto savedPrice = priceService.save(priceDto);


        List<Object> objectList = new ArrayList<>();
        objectList.add(savedCat);
        objectList.add(savedPrice);

        return objectList;
    }

    @Override
    public List<Object> updateRoomCategory(RoomCategoryAndPriceRequestWithId roomAndPriceRequestWithId) {
        RoomCategory roomCategory = roomCategoryDao.findById(roomAndPriceRequestWithId.getRoomCategoryId()).orElse(null);
        if (roomCategory == null) {
            return null;
        } else {
            roomCategory.setRoomType(roomAndPriceRequestWithId.getRoomType());
            roomCategoryDao.save(roomCategory);


        }
        return null;
    }
}
