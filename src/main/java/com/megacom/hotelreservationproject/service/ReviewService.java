package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;

public interface ReviewService {

    ReviewDto save(ReviewDto reviewDto);

    ReviewDto findById(Long Id);

    ReviewDto findByGuestId(Long id);

    ReviewDto findByHotelId(Long id);

    ReviewDto findByResponseId(Long id);

    ReviewDto update(ReviewDto reviewDto);

    ReviewDto delete(ReviewDto reviewDto);
}
