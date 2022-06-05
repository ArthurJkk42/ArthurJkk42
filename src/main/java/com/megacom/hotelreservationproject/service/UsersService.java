package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.UsersDto;

public interface UsersService {

    UsersDto save(UsersDto usersDto);

    UsersDto findById(Long id);

    UsersDto update(UsersDto usersDto);

    UsersDto delete(UsersDto usersDto);
}
