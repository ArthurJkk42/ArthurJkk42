package com.megacom.hotelreservationproject.mappers;


import com.megacom.hotelreservationproject.models.entity.RoomCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomCategoryMapper {

    RoomCategoryMapper INSTANCE = Mappers.getMapper(RoomCategoryMapper.class);

    RoomCategory roomCategoryDtoToRoomCategory(com.megacom.hotelreservationproject.models.dto.RoomCategoryDto roomCategoryDto);

    com.megacom.hotelreservationproject.models.dto.RoomCategoryDto roomCategoryToRoomCategoryDto(RoomCategory roomCategory);

    List<RoomCategory> roomCategoryDtoListToRoomCategoryList(List<com.megacom.hotelreservationproject.models.dto.RoomCategoryDto> roomCategoryDtoList);

    List<com.megacom.hotelreservationproject.models.dto.RoomCategoryDto> roomCategoryListToRoomCategoryDtoList(List<RoomCategory> roomCategories);
}
