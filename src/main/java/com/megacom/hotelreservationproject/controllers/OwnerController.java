package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.BookingDto;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;
import com.megacom.hotelreservationproject.service.BookingService;
import com.megacom.hotelreservationproject.service.HotelService;
import com.megacom.hotelreservationproject.service.ReviewResponseService;
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
    private ReviewResponseService reviewResponseService;

    @PostMapping("/save")
    public HotelDto save(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @PostMapping("/cancel")
    public BookingDto cancel(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByOwner(bookingDto);
    }

    @PostMapping("/respond")
    public ReviewResponseDto respond(@RequestBody ReviewResponseDto reviewResponseDto) {
        return null;
    }
}
