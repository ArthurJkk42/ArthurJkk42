package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.RoomCategoryDto;

public interface RoomCategoryService {
    
    RoomCategoryDto save(RoomCategoryDto roomCategoryDto);

    RoomCategoryDto update(RoomCategoryDto roomCategoryDto);


}
