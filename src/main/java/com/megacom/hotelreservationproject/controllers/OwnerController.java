package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.*;
import com.megacom.hotelreservationproject.service.*;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/owner")
public class OwnerController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CityService cityService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ReviewResponseService reviewResponseService;
    @Autowired
    private PriceService priceService;

    @PostMapping("/saveHotel")
    public HotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @PostMapping("/updateHotel")
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.update(hotelDto);
    }

    @PostMapping("/saveRoom")
    public RoomDto saveRoom(@RequestBody RoomDto roomDto) {
        return roomService.save(roomDto);
    }

    @PostMapping("/updateRoom")
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomService.update(roomDto);
    }

    @PostMapping("/saveCity")
    public CityDto saveCity(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PostMapping("updateCity")
    public CityDto updateCity(@RequestBody CityDto cityDto) {
        return cityService.update(cityDto);
    }

    @PostMapping("/uploadPhotos")
    public PhotoDto uploadPhotos(@RequestBody PhotoDto photoDto) {
        return null;
    }

    @PostMapping("/updatePhotos")
    public PhotoDto updatePhotos(@RequestBody PhotoDto photoDto) {
        return null;
    }

    @PostMapping("/deletePhotos")
    public PhotoDto deletePhotos(@RequestBody PhotoDto photoDto) {
        return null;
    }

    @PostMapping("/respondToReview")
    public ReviewResponseDto respondToReview(@RequestBody ReviewDto reviewDto, ReviewResponseDto reviewResponseDto) throws ParseException {
        return reviewResponseService.reviewRespond(reviewDto, reviewResponseDto);
    }

    // throws ParseException мб нужно удалить
    @PostMapping("/editResponse")
    public ReviewResponseDto editResponse(@RequestBody ReviewResponseDto reviewResponseDto) throws ParseException {
        return reviewResponseService.editResponseToReview(reviewResponseDto);
    }

    // throws ParseException мб нужно удалить
    @PostMapping("/deleteRespondToReview")
    public ReviewResponseDto deleteRespondToReview(@RequestParam ReviewResponseDto reviewResponseDto) throws ParseException {
        return reviewResponseService.deleteResponseToReview(reviewResponseDto);
    }

    @PostMapping("/book")
    public BookingDto book(@RequestBody BookingDto bookingDto) {
        return bookingService.saveByHotel(bookingDto);
    }

    @PostMapping("/updateBooking")
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.update(bookingDto);
    }

    @PostMapping("/cancelBooking")
    public BookingDto cancelBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.cancelBookingByOwner(bookingDto);
    }

    @PostMapping("/setPrice")
    public PriceDto setPrice(@RequestBody PriceDto priceDto) {
        return priceService.save(priceDto);
    }

    @PostMapping("/updatePrice")
    public PriceDto updatePrice(@RequestBody PriceDto priceDto) {
        return priceService.update(priceDto);
    }
}
