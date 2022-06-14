package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.UserDto;
import com.megacom.hotelreservationproject.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User roomDtoToRoom(UserDto userDto);

    UserDto userToUserDto(User user);

    List<User> userDtoListToUserList(List<UserDto> userDtoList);

    List<UserDto> userListToUserDtoList(List<User> userList);
}
