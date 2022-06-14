package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.CityDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface CityService {

    CityDto save(CityDto cityDto);

    CityDto findById(Long cityId);

    ResponseEntity<?> findFilteredByCity(Long cityId, Date checkInDate, Date checkOutDate,
                                         int guestCount, int roomCount);

    CityDto update(CityDto cityDto);

    CityDto findCityByName(String cityName); // to be removed (maybe)

    List<CityDto> findAllCities(CityDto cityDto);
}
