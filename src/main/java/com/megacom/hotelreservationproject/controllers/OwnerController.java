package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.*;
import com.megacom.hotelreservationproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/owner")
public class OwnerController {

    @Autowired
    private HotelService hotelService;
    private BookingService bookingService;
    private CityService cityService;
    private RoomService roomService;
    private ReviewResponseService reviewResponseService;

    @PostMapping("/saveHotel")
    public HotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @PostMapping("/saveRoom")
    public RoomDto saveRoom(@RequestBody RoomDto roomDto) {
        return roomService.save(roomDto);
    }

    @PostMapping("/saveCity")
    public CityDto saveCity(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PostMapping("/uploadPhotos")
    public PhotoDto uploadPhoto(@RequestBody PhotoDto photoDto) {
        return null;
    }

    @PostMapping("/respondToReview")
    public ReviewResponseDto respondToReview(@RequestBody ReviewResponseDto reviewResponseDto) {
        return null;
    }

    @PostMapping("/cancelBooking")
    public BookingDto cancelBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByOwner(bookingDto);
    }

    @PostMapping("/bookRoom")
    public void book() {
    }
}
