package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.BookingDao;
import com.megacom.hotelreservationproject.mappers.BookingMapper;
import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.entity.Booking;
import com.megacom.hotelreservationproject.models.enums.EBookingStatus;
import com.megacom.hotelreservationproject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;
    private BookingMapper bookingMapper = BookingMapper.INSTANCE;

    @Override
    public BookingDto userBook(BookingDto bookingDto) {
        Booking booking = bookingMapper.bookingDtoToBooking(bookingDto);
        booking.setStatus(EBookingStatus.BOOKED_BY_USER);
        Booking bookingSaved =bookingDao.save(booking);
        return bookingMapper.bookingToBookingDto(bookingSaved);
    }

    @Override
    public BookingDto bookByHotel(BookingDto bookingDto) {
        Booking booking = bookingMapper.bookingDtoToBooking(bookingDto);
        booking.setStatus(EBookingStatus.BOOKED_BY_HOTEL);
        Booking bookingSaved =bookingDao.save(booking);
        return bookingMapper.bookingToBookingDto(bookingSaved);
    }

    @Override
    public BookingDto findById(Long id) {
        Booking booking = bookingDao.findById(id).orElse(null);
        return bookingMapper.bookingToBookingDto(booking);
    }

    @Override
    public BookingDto update(BookingDto bookingDto) {
        boolean isExists = bookingDao.existsById(bookingDto.getId());
        if (!isExists) {
            return null;
        } else {
            Booking booking = bookingMapper.bookingDtoToBooking(bookingDto);
            Booking updatedBooking = bookingDao.save(booking);
            return bookingMapper.bookingToBookingDto(updatedBooking);
        }
    }

    @Override
    public BookingDto cancelBookingByOwner(BookingDto bookingDto) {
        boolean isExists = bookingDao.existsById(bookingDto.getId());
        if (!isExists) {
            return null;
        } else {
            Booking booking = bookingMapper.bookingDtoToBooking(bookingDto);
            booking.setStatus(EBookingStatus.CANCELLED_BY_HOTEL);
            BookingDto cancelledBooking = update(bookingMapper.bookingToBookingDto(booking));
            return cancelledBooking;
        }
    }

    @Override
    public BookingDto cancelBookingByUser(BookingDto bookingDto) {
        boolean isExists = bookingDao.existsById(bookingDto.getId());
        if (!isExists) {
            return null;
        } else {
            Booking booking = bookingMapper.bookingDtoToBooking(bookingDto);
            booking.setStatus(EBookingStatus.CANCELLED_BY_USER);
            BookingDto cancelledBooking = update(bookingMapper.bookingToBookingDto(booking));
            return cancelledBooking;
        }
    }


    @Override
    public BookingDto findBookingByHotelId(Long id) {
        return null;
    }

    @Override
    public BookingDto bookRoom() {
        return null;
    }

    @Override
    public BookingDto cancelBookingRoom() {
        return null;
    }

    @Override
    public BookingDto bookingEmailSender() {
        return null;
    }

    @Override
    public List<BookingDto> findAllBookingsByCheckOutDate(Date date) {
        return null;
    }

    @Override
    public List<BookingDto> findAllBookingsByCheckInDate(Date date) {
        return null;
    }

    @Override
    public List<BookingDto> findAllBookingsByGuestId(Long id) {
        return null;
    }

    @Override
    public List<BookingDto> findAllBookingsByHotel(Long id) {
        return null;
    }
}
