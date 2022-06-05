package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.CityDto;

public interface CityService {

    CityDto save(CityDto cityDto);

    CityDto findById(CityDto cityDto);

    CityDto update(CityDto cityDto);

    CityDto delete(CityDto cityDto);


}
