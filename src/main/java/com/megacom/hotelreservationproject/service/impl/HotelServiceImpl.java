package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.HotelDao;
import com.megacom.hotelreservationproject.mappers.HotelMapper;
import com.megacom.hotelreservationproject.mappers.PhotoMapper;
import com.megacom.hotelreservationproject.models.dto.CityDto;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.enums.EHotelStatus;
import com.megacom.hotelreservationproject.models.response.HotelResponse;
import com.megacom.hotelreservationproject.service.HotelService;
import com.megacom.hotelreservationproject.service.ReviewService;
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
    @Autowired
    private CityServiceImpl cityService;
    @Autowired
    private ReviewService reviewService;

    private final HotelMapper hotelMapper = HotelMapper.INSTANCE;
    private final PhotoMapper photoMapper = PhotoMapper.INSTANCE;

    @Override
    public HotelDto save(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
        hotel.setHotelStatus(EHotelStatus.ACTIVE);
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
        Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
        Hotel updatedHotel = hotelDao.save(hotel);
        return hotelMapper.hotelToHotelDto(updatedHotel);
    }
    }

    @Override
    public HotelDto setActive(HotelDto hotelDto) {
        boolean isExists = hotelDao.existsById(hotelDto.getId());
        if (!isExists) {
            return null;
        } else {
            Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
            hotel.setHotelStatus(EHotelStatus.ACTIVE);
            HotelDto activatedHotel = update(hotelMapper.hotelToHotelDto(hotel));
            return activatedHotel;
        }
    }

    @Override
    public HotelDto delete(HotelDto hotelDto) {
        boolean isExists = hotelDao.existsById(hotelDto.getId());
        if (!isExists) {
            return null;
        } else {
            Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
            hotel.setHotelStatus(EHotelStatus.DELETED);
            HotelDto deletedHotel = update(hotelMapper.hotelToHotelDto(hotel));
            return deletedHotel;
        }
    }

    @Override
    public HotelDto block(HotelDto hotelDto) {
        boolean isExists = hotelDao.existsById(hotelDto.getId());
        if (!isExists) {
            return null;
        } else {
            Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
            hotel.setHotelStatus(EHotelStatus.BLOCKED);
            HotelDto deletedHotel = update(hotelMapper.hotelToHotelDto(hotel));
            return deletedHotel;
        }
    }

    @Override
    public HotelDto findHotelByUser(Long id) {
        return null;
    }

    @Override
    public void countCurrentScore() {
    List<HotelDto>hotelDtoList = findAllHotels();
    hotelDtoList.stream().forEach(x -> {
        List<ReviewDto> reviewDtoList = reviewService.findAllByHotelAndActive(x);
        Double sum = reviewDtoList.stream().mapToDouble(ReviewDto::getScore).sum();
        Double currentScore = Math.round((sum / reviewDtoList.size())/10.0) * 10.0;

        // на случай если double округление не работает
        String result = String.format("%.1f", currentScore);

        x.setCurrentScore(currentScore);
        update(x);
    });
    }

    @Override
    public List<HotelDto> findAllHotels() {
        return hotelMapper.hotelListToHotelDtoList(hotelDao.findAll());
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
    public ResponseEntity<?> filterByCity(Long cityId, Date checkInDate,
                                          Date checkOutDate, int guestCount, int roomCount) {
        CityDto cityDto = cityService.findById(cityId);
        if (cityDto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // null, 404
        }
        List<Hotel> hotelList = hotelDao.findHotelsByCityId(cityId);
        hotelList.stream().forEach(x -> {
        });
        return null;
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
