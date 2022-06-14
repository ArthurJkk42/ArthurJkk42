package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto save(ReviewDto reviewDto);

    ReviewDto findById(Long id);

    ReviewDto delete(ReviewDto reviewDto);

    ReviewDto reviewAndRate(ReviewDto reviewDto); // required

    List<ReviewDto> findByGuestId(Long id);

    List<ReviewDto> findByHotelId(Long id);

    List<ReviewDto> findByReviewResponseId(Long id);
}
