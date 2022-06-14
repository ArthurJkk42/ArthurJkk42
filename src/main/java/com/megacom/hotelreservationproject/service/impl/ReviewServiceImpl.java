package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.ReviewDao;
import com.megacom.hotelreservationproject.mappers.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.entity.Review;
import com.megacom.hotelreservationproject.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    private ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        Review review = reviewMapper.reviewDtoToReview(reviewDto);
        Review reviewSaved = reviewDao.save(review);
        return reviewMapper.reviewToReviewDto(reviewSaved);
    }

    @Override
    public ReviewDto findById(Long id) {
        Review review = reviewDao.findById(id).orElse(null);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public ReviewDto delete(ReviewDto reviewDto) {
        return null;
    }

    @Override
    public ReviewDto reviewAndRate(ReviewDto reviewDto) {
        Review review = reviewMapper.reviewDtoToReview(reviewDto);
        Review reviewSaved = reviewDao.save(review);
        return reviewMapper.reviewToReviewDto(reviewSaved);
    }

    @Override
    public List<ReviewDto> findByGuestId(Long id) {
        return null;
    }

    @Override
    public List<ReviewDto> findByHotelId(Long id) {
        return null;
    }

    @Override
    public List<ReviewDto> findByReviewResponseId(Long id) {
        return null;
    }
}
