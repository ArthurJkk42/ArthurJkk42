package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.*;
import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequest;
import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequestWithId;
import com.megacom.hotelreservationproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

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
    @Autowired
    private FileService fileService;
    @Autowired
    private RoomAndPriceService roomAndPriceService;

    @PostMapping("/saveHotel") // works
    public HotelDto saveHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.save(hotelDto);
    }

    @PostMapping("/updateHotel") // works
    public HotelDto updateHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.update(hotelDto);
    }

    @PostMapping("/saveRoom")
    public List<Object> saveRoom(@RequestBody RoomCategoryAndPriceRequest roomAndPriceRequest) {
        return roomAndPriceService.save(roomAndPriceRequest);
    }

    @PostMapping("/updateRoomCategory")
    public List<Object> updateRoom(@RequestBody RoomCategoryAndPriceRequestWithId roomAndPriceRequestWithId) {
        return roomAndPriceService.updateRoomCategory(roomAndPriceRequestWithId);
    }

    @PostMapping("/saveCity") // works
    public CityDto saveCity(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @PostMapping("updateCity") // works
    public CityDto updateCity(@RequestBody CityDto cityDto) {
        return cityService.update(cityDto);
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImageToHotel(@RequestParam MultipartFile file, @RequestParam Long hotelId, @RequestParam int orderNum) {
        return fileService.uploadImageToHotel(file, hotelId, orderNum);
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
    public ReviewResponseDto respondToReview(@RequestParam Long reviewId, ReviewResponseDto reviewResponseDto) throws ParseException {
        return reviewResponseService.reviewRespond(reviewId, reviewResponseDto);
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
