package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto save(ReviewDto reviewDto);

    ReviewDto findById(Long id);

    ReviewDto delete(ReviewDto reviewDto);

    List<ReviewDto>findAllByHotelAndActive(HotelDto hotelDto);

    ReviewDto reviewAndRate(HotelDto hotelDto, double score, String text); // required

    List<ReviewDto> findByGuestId(Long id);

    List<ReviewDto> findByHotelId(Long id);

    List<ReviewDto> findByReviewResponseId(Long id);
}
