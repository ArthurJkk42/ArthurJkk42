package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.RoomDto;
import com.megacom.hotelreservationproject.models.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto usersDto);

    UserDto findById(Long id);

    UserDto update(UserDto usersDto);

    UserDto block(UserDto usersDto);

    UserDto addOwnerAndGiveRights(UserDto userDto);

    List<RoomDto> findByRoomId(Long id);

    List<RoomDto> findByBookingId(Long id);

    List<RoomDto> findByCityId(Long id);

    List<RoomDto> findByHotelId(Long id);

    List<UserDto> findByReviewId(Long id);
}
