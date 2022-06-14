package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.HotelDao;
import com.megacom.hotelreservationproject.mappers.HotelMapper;
import com.megacom.hotelreservationproject.models.dto.CityDto;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.response.HotelResponse;
import com.megacom.hotelreservationproject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {


    @Autowired
    private HotelDao hotelDao;
    private HotelMapper hotelMapper = HotelMapper.INSTANCE;
    private CityServiceImpl cityService;

    @Override
    public HotelDto save(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
        hotel.setActive(true);
        Hotel hotelSaved = hotelDao.save(hotel);
        return hotelMapper.hotelToHotelDto(hotelSaved);
    }

    @Override
    public HotelDto findById(Long id) {
        Hotel hotel = hotelDao.findById(id).orElse(null);
        return hotelMapper.hotelToHotelDto(hotel);
    }

    @Override
    public HotelDto update(HotelDto hotelDto) {
    boolean isExists = hotelDao.existsById(hotelDto.getId());
    if (!isExists) {
        return null;
    } else {
        Hotel hotel =hotelMapper.hotelDtoToHotel(hotelDto);
        Hotel updatedHotel = hotelDao.save(hotel);
        return hotelMapper.hotelToHotelDto(updatedHotel);
        }
    }

    @Override
    public HotelDto delete(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
        hotel.setActive(false);
        HotelDto deletedHotel = update(hotelMapper.hotelToHotelDto(hotel));
        return deletedHotel;
    }

    @Override
    public HotelDto blockHotel(HotelDto hotelDto) {
        return null;
    }

    @Override
    public HotelDto findHotelByUser(Long id) {
        return null;
    }

    @Override
    public List<String> uploadHotelPhotos() {
        return null;
    }

    @Override
    public ResponseEntity<?> findHotelsByCityIdAndRating(Long cityId) { //required
        CityDto cityDto = cityService.findById(cityId);
        if (cityDto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // null, 404
        }
        List<Hotel> hotelList = hotelDao.findHotelsByCityId(cityId);
        List<HotelResponse> hotelResponses = hotelMapper.convertToResponseList(hotelList);
        hotelResponses.stream()
                .sorted(Comparator.comparingDouble(HotelResponse::getCurrentScore))
                .forEach(p -> hotelResponses.add(p));
        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }

    @Override
    public List<HotelDto> findConvenientHotelsByDate(Date CheckInDate, Date checkOutDate) {
        return null;
    }

    @Override
    public List<HotelDto> findConvenientHotelsByGuestsAmount(Long guestAmount) {
        return null;
    }

    @Override
    public List<HotelDto> findFreeRoomsAmountByHotel(HotelDto hotelDto) {
        return null;
    }

    @Override
    public List<HotelDto> filterHotelsByRatings(double score) {
        return null;
    }
}
