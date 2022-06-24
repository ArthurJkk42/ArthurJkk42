package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.HotelDao;
import com.megacom.hotelreservationproject.dao.ReviewDao;
import com.megacom.hotelreservationproject.mappers.HotelMapper;
import com.megacom.hotelreservationproject.mappers.ReviewMapper;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.entity.Review;
import com.megacom.hotelreservationproject.service.ReviewService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private HotelDao hotelDao;

    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;
    private final HotelMapper hotelMapper = HotelMapper.INSTANCE;

    @Override
    public ReviewDto save(ReviewDto reviewDto) throws ParseException {
        Review review = reviewMapper.reviewDtoToReview(reviewDto);

        String currentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        Date convertedCurrentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(currentDate);

        review.setReviewDate(convertedCurrentDate);

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
    public List<ReviewDto> findAllByHotelAndActive(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.hotelDtoToHotel(hotelDto);
        return reviewMapper.reviewListToReviewDtoList(reviewDao.findAllByActiveTrueAndHotel(hotel));
    }

    @Override
    public ReviewDto reviewAndRate(Long hotelId, ReviewDto reviewDto) throws ParseException {
        boolean isExists = hotelDao.existsById(hotelId);
        if (!isExists) {
            return null;
        } else {
            return save(reviewDto);
        }
    }

    @Override
    public ReviewDto editReview(ReviewDto reviewDto) throws ParseException {
        boolean isExists = reviewDao.existsById(reviewDto.getId());
        if (!isExists) {
            return null;
        }
        else {
            return save(reviewDto);
        }
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
