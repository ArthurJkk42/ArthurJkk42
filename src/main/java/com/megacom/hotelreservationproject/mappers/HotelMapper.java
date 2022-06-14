package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.response.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    Hotel hotelDtoToHotel(HotelDto hotelDto);

    HotelDto hotelToHotelDto(Hotel hotel);

    List<Hotel> hotelDtoListToHotelList(List<HotelDto> hotelDtoList);

    List<HotelDto> hotelToHotelDto(List<Hotel> hotelList);

    default HotelResponse hotelToHotelResponse(Hotel hotel) {
        if (hotel == null) {
            return null;
        }
        HotelResponse hotelResponse = new HotelResponse();

        hotelResponse.setId(hotel.getId());
        hotelResponse.setName(hotel.getName());
        hotelResponse.setDescription(hotel.getDescription());
        hotelResponse.setAddress(hotel.getAddress());

        hotelResponse.setPhotos(hotel.getPhotos().getPhotoLink());

//        if (list != null) {
//            hotelResponse.setPhotos(new ArrayList<String>(list));
//        }
        hotelResponse.setCurrentScore(hotel.getCurrentScore());
        return hotelResponse;
    }

    default List<HotelResponse> convertToResponseList(List<Hotel> hotelList) {
        if (hotelList == null) {
            return null;
        }
        List<HotelResponse> hotelResponses = new ArrayList<HotelResponse>(hotelList.size());
        for (Hotel hotel : hotelList) {
            hotelResponses.add(hotelToHotelResponse(hotel));
        }
        return hotelResponses;
    }
}
