package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.UserDao;
import com.megacom.hotelreservationproject.mappers.UserMapper;
import com.megacom.hotelreservationproject.models.dto.RoomDto;
import com.megacom.hotelreservationproject.models.dto.UserDto;
import com.megacom.hotelreservationproject.models.entity.User;
import com.megacom.hotelreservationproject.models.enums.EUserStatus;
import com.megacom.hotelreservationproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDto save(UserDto usersDto) {
        User user = userMapper.roomDtoToRoom(usersDto);
        user.setUserStatus(EUserStatus.REGISTERED);
        User userSaved = userDao.save(user);
        return userMapper.userToUserDto(userSaved);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElse(null);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto update(UserDto usersDto) {
        return null;
    }

    @Override
    public UserDto block(UserDto usersDto) {
        return null;
    }

    @Override
    public UserDto addOwnerAndGiveRights(UserDto userDto) {
        return null;
    }

    @Override
    public List<RoomDto> findByRoomId(Long id) {
        return null;
    }

    @Override
    public List<RoomDto> findByBookingId(Long id) {
        return null;
    }

    @Override
    public List<RoomDto> findByCityId(Long id) {
        return null;
    }

    @Override
    public List<RoomDto> findByHotelId(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findByReviewId(Long id) {
        return null;
    }
}
