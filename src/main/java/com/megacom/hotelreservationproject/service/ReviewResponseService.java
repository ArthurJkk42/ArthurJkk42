package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;

import java.text.ParseException;
import java.util.List;

public interface ReviewResponseService {

    ReviewResponseDto save(ReviewResponse reviewResponse);

    ReviewResponseDto findById(Long id);

    ReviewResponseDto update(ReviewResponseDto reviewResponse);

    ReviewResponseDto reviewRespond(ReviewDto reviewDto, ReviewResponseDto reviewResponseDto) throws ParseException; // required

    ReviewResponseDto editResponseToReview(ReviewResponseDto reviewResponseDto) throws ParseException;

    ReviewResponseDto deleteResponseToReview(ReviewResponseDto reviewResponseDto) throws ParseException;

    List<ReviewResponseDto> findByResponse(Long id);

    List<ReviewResponseDto> findByHotel(Long id);

    List<ReviewResponseDto> findByBooking(Long id);

    List<ReviewResponseDto> findByUser(Long id);
}
