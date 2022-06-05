package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.CityDto;
import com.megacom.hotelreservationproject.models.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City cityDtoToCity(CityDto cityDto);

    CityDto cityToCityDto(City city);

    List<City> cityDtoListToCityList(List<CityDto> cityDtoList);

    List<CityDto> cityToCityDto(List<City> cityList);
}
