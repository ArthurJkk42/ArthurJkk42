package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.ReviewDao;
import com.megacom.hotelreservationproject.dao.ReviewResponseDao;
import com.megacom.hotelreservationproject.mappers.ReviewResponseMapper;
import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;
import com.megacom.hotelreservationproject.models.entity.Review;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import com.megacom.hotelreservationproject.service.ReviewResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewResponseServiceImpl implements ReviewResponseService {

    @Autowired
    private ReviewResponseDao reviewResponseDao;
    private ReviewDao reviewDao;
    private ReviewResponseService reviewResponseService;
    private ReviewResponseMapper reviewResponseMapper = ReviewResponseMapper.INSTANCE;

    @Override
    public ReviewResponseDto save(ReviewResponseDto reviewResponseDto) {
        ReviewResponse reviewResponse = reviewResponseMapper.reviewResponseDtoToReviewResponse(reviewResponseDto);
        ReviewResponse reviewResponseSaved = reviewResponseDao.save(reviewResponse);
        return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponseSaved);
    }

    @Override
    public ReviewResponseDto findById(Long id) {
        ReviewResponse reviewResponse =reviewResponseDao.findById(id).orElse(null);
        return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponse);
    }

    @Override
    public ReviewResponseDto update(ReviewResponseDto reviewResponse) {
        return null;
    }

    @Override
    public ReviewResponseDto reviewRespond(Long id) {
        boolean isExists = reviewDao.existsById(id);
        if (!isExists) {
            return null;
        } else {
            ReviewResponseDto reviewResponseDto;
//            reviewResponseService.generateReviewRespond(reviewResponseDto);
        }
        return null;
    }

    @Override
    public ReviewResponseDto generateReviewRespond(ReviewResponseDto reviewResponseDto) {
        ReviewResponse reviewResponse = reviewResponseMapper.reviewResponseDtoToReviewResponse(reviewResponseDto);
        return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponse);
    }

    @Override
    public List<ReviewResponseDto> findByResponse(Long id) {
        return null;
    }

    @Override
    public List<ReviewResponseDto> findByHotel(Long id) {
        return null;
    }

    @Override
    public List<ReviewResponseDto> findByBooking(Long id) {
        return null;
    }

    @Override
    public List<ReviewResponseDto> findByUser(Long id) {
        return null;
    }
}
