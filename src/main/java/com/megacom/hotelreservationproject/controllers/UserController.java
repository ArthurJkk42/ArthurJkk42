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

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/searchForHotels")
    public ResponseEntity<?> search(@RequestParam Long cityId) {
        return hotelService.findHotelsByCityIdAndRating(cityId);
    }

    @GetMapping("/filterSearch")
    public ResponseEntity<?> filterByCity(@RequestParam Long cityId,
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

    @PostMapping("/book")
    public BookingDto bookRoom(@RequestBody BookingDto bookingDto) {
        return bookingService.saveByUser(bookingDto);
    }

    @PostMapping("/updateBooking")
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.update(bookingDto);
    }

    @PostMapping("/cancelBooking")
    public BookingDto cancelBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByUser(bookingDto);
    }

    @PostMapping("/reviewFeedback")
    public ReviewDto reviewFeedback(@RequestParam Long hotelId, @RequestBody ReviewDto reviewDto) throws ParseException {
        return reviewService.reviewAndRate(hotelId, reviewDto);
    }

    @PostMapping("/editReview")
    public ReviewDto editReview(@RequestBody ReviewDto reviewDto) throws ParseException {
        return reviewService.editReview(reviewDto);
    }
}
