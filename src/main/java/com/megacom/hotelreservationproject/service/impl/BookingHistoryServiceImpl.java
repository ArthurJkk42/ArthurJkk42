package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.BookingDao;
import com.megacom.hotelreservationproject.dao.BookingHistoryDao;
import com.megacom.hotelreservationproject.mappers.BookingHistoryMapper;
import com.megacom.hotelreservationproject.mappers.BookingMapper;
import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.BookingHistoryDto;
import com.megacom.hotelreservationproject.models.entity.Booking;
import com.megacom.hotelreservationproject.models.entity.BookingHistory;
import com.megacom.hotelreservationproject.models.enums.EBookingStatus;
import com.megacom.hotelreservationproject.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {

    @Autowired
    private BookingHistoryDao bookingHistoryDao;

    private final String pattern = "dd.MM.yyyy";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private BookingHistoryMapper bookingHistoryMapper = BookingHistoryMapper.INSTANCE;

    @Override
    public BookingHistoryDto save(BookingHistoryDto bookingHistoryDto) {
        BookingHistory bookingHistory = bookingHistoryMapper.bookingHistoryDtoToBookingHistory(bookingHistoryDto);
        bookingHistory.setStatus(EBookingStatus.BOOKED);
        BookingHistory bookingHistorySaved = bookingHistoryDao.save(bookingHistory);
        return bookingHistoryMapper.bookingHistoryToBookingHistoryDto(bookingHistory);
    }

    @Override
    public BookingHistoryDto findById(Long id) {
        BookingHistory bookingHistory = bookingHistoryDao.findById(id).orElse(null);
        return bookingHistoryMapper.bookingHistoryToBookingHistoryDto(bookingHistory);
    }

    @Override
    public List<BookingHistoryDto> findAllBookingHistoryByBooking(BookingDto bookingDto) {
        return null;
    }
}
