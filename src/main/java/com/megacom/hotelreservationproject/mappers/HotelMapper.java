package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    Hotel hotelDtoToHotel(HotelDto hotelDto);

    HotelDto hotelToHotelDto(Hotel hotel);

    List<Hotel> hotelDtoListToHotelList(List<HotelDto> hotelDtoList);

    List<HotelDto> hotelToHotelDto(List<Hotel> hotelList);
}
