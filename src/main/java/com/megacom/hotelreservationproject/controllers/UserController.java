package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.dao.ReviewDao;
import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.response.HotelResponse;
import com.megacom.hotelreservationproject.service.BookingService;
import com.megacom.hotelreservationproject.service.HotelService;
import com.megacom.hotelreservationproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private HotelService hotelService;
    private BookingService bookingService;
    private ReviewService reviewService;

    @GetMapping("/search")
    private ResponseEntity<?> search(@RequestParam Long cityId) {
        return hotelService.findHotelsByCityIdAndRating(cityId);
    }

    @GetMapping("/filter")
        private ResponseEntity<?> filter(@RequestParam Long cityId, Date checkInDate, Date checkOutDate,
                                         int guestCount, int roomCount) {
        return null;
    }

    @PostMapping("/book")
    public BookingDto book(@RequestBody BookingDto bookingDto) {
        return bookingService.bookByUser(bookingDto);
    }

    @PostMapping("/cancel")
    public BookingDto cancel(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByUser(bookingDto);
    }

    @PostMapping("/review")
    public ReviewDto review(@RequestBody ReviewDto reviewDto) {
        return reviewService.reviewAndRate(reviewDto);
    }
}
