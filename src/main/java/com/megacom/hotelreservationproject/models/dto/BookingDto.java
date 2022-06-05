package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.Room;
import com.megacom.hotelreservationproject.models.entity.Users;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Data
public class BookingDto {
    private Long id;
    private Hotel hotel;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private Users users;
    private String comment;
    private boolean status;
    private String sum;

    @Mapper
    public static interface UsersMapper {

        UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

        Users usersDtoToUsers(UsersDto roomDto);

        UsersDto usersToUsersDto(Users room);

        List<Users> usersDtoListToUsersList(List<UsersDto> roomDtoList);

        List<UsersDto> usersListToUsersDtoList(List<Users> roomList);
    }
}
