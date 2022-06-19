package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.enums.EBedType;
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

    @GetMapping("/searchForHotels")
    public ResponseEntity<?> search(@RequestParam Long cityId) {
        return hotelService.findHotelsByCityIdAndRating(cityId);
    }

    @GetMapping("/filterSearch")
        public ResponseEntity<?> filter(@RequestParam Long cityId,
                                         Date checkInDate, Date checkOutDate,
                                         int guestCount, int roomCount) {
        return null;
    }

    @GetMapping("/filterByRating")
    public HotelDto filterRating(@RequestParam double score) {
        return null;
    }

    @GetMapping("/filterByBed")
    public HotelDto filterBed(@RequestParam EBedType bedType) {
        return null;
    }

    @GetMapping("/getAvailableRoomOptions")
    public HotelDto getAvailableRoomOptions() {
        return null;
    }

    @PostMapping("/bookRoom")
    public BookingDto bookRoom(@RequestBody BookingDto bookingDto) {
        return bookingService.userBook(bookingDto);
    }

    @PostMapping("/cancelBooking")
    public BookingDto cancelBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByUser(bookingDto);
    }

    @PostMapping("/reviewFeedback")
    public ReviewDto reviewFeedback(@RequestParam HotelDto hotelDto, double score, String text) {
        return reviewService.reviewAndRate(hotelDto, score, text);
    }
}
