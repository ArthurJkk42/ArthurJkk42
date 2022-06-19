package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.BookingHistoryDto;
import com.megacom.hotelreservationproject.models.entity.BookingHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingHistoryMapper {

    BookingHistoryMapper INSTANCE = Mappers.getMapper(BookingHistoryMapper.class);

    BookingHistory bookingHistoryDtoToBookingHistory(BookingHistoryDto bookingHistoryDto);

    BookingHistoryDto bookingHistoryToBookingHistoryDto(BookingHistory bookingHistory);

    List<BookingHistory> bookingHistoryDtoListToBookingHistoryList(List<BookingHistoryDto> bookingHistoryDtoList);

    List<BookingHistoryDto> bookingHistoryListToBookingHistoryDtoList(List<BookingHistory> bookingHistoryList);
}
