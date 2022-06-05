package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;

public interface ReviewResponseService {

    ReviewResponseDto save(ReviewResponseDto reviewResponse);

    ReviewResponseDto findById(Long id);

    ReviewResponseDto update(ReviewResponseDto reviewResponse);

    ReviewResponseDto delete(ReviewResponseDto reviewResponse);
}
