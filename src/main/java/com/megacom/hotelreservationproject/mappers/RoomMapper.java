package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.RoomDto;
import com.megacom.hotelreservationproject.models.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    Room roomDtoToRoom(RoomDto roomDto);

    RoomDto roomToRoomDto(Room room);

    List<Room> roomDtoListToRoomList(List<RoomDto> roomDtoList);

    List<RoomDto> roomListToRoomDtoList(List<Room> roomList);
}
