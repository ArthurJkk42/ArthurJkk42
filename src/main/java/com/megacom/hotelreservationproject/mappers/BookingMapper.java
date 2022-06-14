package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    Booking bookingDtoToBooking(BookingDto bookingDto);

    BookingDto bookingToBookingDto(Booking booking);

    List<BookingDto> bookingDtoListToBookingList(List<BookingDto> bookingDtoList);

    List<BookingDto> bookingToBookingDto(List<BookingDto> bookingDtoList);
}
