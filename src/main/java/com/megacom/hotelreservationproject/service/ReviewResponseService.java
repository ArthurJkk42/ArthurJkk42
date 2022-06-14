package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewResponseService {

    ReviewResponseDto save(ReviewResponseDto reviewResponseDto);

    ReviewResponseDto findById(Long id);

    ReviewResponseDto update(ReviewResponseDto reviewResponse);

    ReviewResponseDto reviewRespond(Long id); // required

    ReviewResponseDto generateReviewRespond(ReviewResponseDto reviewResponseDto); // required

    List<ReviewResponseDto> findByResponse(Long id);

    List<ReviewResponseDto> findByHotel(Long id);

    List<ReviewResponseDto> findByBooking(Long id);

    List<ReviewResponseDto> findByUser(Long id);
}
