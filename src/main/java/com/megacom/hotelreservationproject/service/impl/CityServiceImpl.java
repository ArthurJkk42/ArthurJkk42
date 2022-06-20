package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.CityDao;
import com.megacom.hotelreservationproject.dao.HotelDao;
import com.megacom.hotelreservationproject.mappers.CityMapper;
import com.megacom.hotelreservationproject.models.dto.CityDto;
import com.megacom.hotelreservationproject.models.entity.City;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.Room;
import com.megacom.hotelreservationproject.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private HotelDao hotelDao;

    private CityMapper cityMapper = CityMapper.INSTANCE;

    @Override
    public CityDto save(CityDto cityDto) {
        City city = cityMapper.cityDtoToCity(cityDto);
        city.setActive(true);
        City citySaved = cityDao.save(city);
        return cityMapper.cityToCityDto(citySaved);
    }

    @Override
    public CityDto findById(Long cityId) {
        City city = cityDao.findById(cityId).orElse(null);
        return cityMapper.cityToCityDto(city);
    }

    @Override
    public ResponseEntity<?> findFilteredByCity(Long cityId, Date checkInDate, Date checkOutDate,
                                                int guestCount, int roomCount) {
        City city = cityDao.findById(cityId).orElse(null);
        List<Hotel> hotelList = hotelDao.findHotelsByCityId(cityId);
//        hotelList.stream()
        return null;
    }

    @Override
    public CityDto update(CityDto cityDto) {
        boolean ifExists = cityDao.existsById(cityDto.getId());
        if (!ifExists) {
            return null;
        } else {
            City city = cityMapper.cityDtoToCity(cityDto);
            City updatedCity = cityDao.save(city);
            return cityMapper.cityToCityDto(updatedCity);
        }
    }

    @Override
    public CityDto findCityByName(String cityName) {
        return null;
    }

    @Override
    public List<CityDto> findAllCities(CityDto cityDto) {
        return null;
    }
}
