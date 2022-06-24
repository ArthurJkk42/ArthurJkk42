package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.ReviewDao;
import com.megacom.hotelreservationproject.dao.ReviewResponseDao;
import com.megacom.hotelreservationproject.mappers.ReviewMapper;
import com.megacom.hotelreservationproject.mappers.ReviewResponseMapper;
import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import com.megacom.hotelreservationproject.service.ReviewResponseService;
import com.megacom.hotelreservationproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReviewResponseServiceImpl implements ReviewResponseService {

    @Autowired
    private ReviewResponseDao reviewResponseDao;
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private ReviewService reviewService;

    private final ReviewResponseMapper reviewResponseMapper = ReviewResponseMapper.INSTANCE;
    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    private final String dateFormat = "dd.MM.yyyy HH:mm:ss";

    @Override
    public ReviewResponseDto save(ReviewResponse reviewResponse) {
        ReviewResponse reviewResponseSaved = reviewResponseDao.save(reviewResponse);
        return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponseSaved);
    }

    @Override
    public ReviewResponseDto findById(Long id) {
        ReviewResponse reviewResponse = reviewResponseDao.findById(id).orElse(null);
        return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponse);
    }

    @Override
    public ReviewResponseDto update(ReviewResponseDto reviewResponse) {
        return null;
    }

    @Override
    public ReviewResponseDto reviewRespond(Long reviewId, ReviewResponseDto reviewResponseDto) throws ParseException {
        boolean isExists = reviewDao.existsById(reviewId);
        if (!isExists) {
            return null;
        } else {
            ReviewResponse reviewResponse = reviewResponseMapper.reviewResponseDtoToReviewResponse(reviewResponseDto);

            String currentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            Date convertedCurrentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(currentDate);

            reviewResponse.setReviewResponseDate(convertedCurrentDate);

            return save(reviewResponse);
        }
    }

    @Override // throwsParseException мб нужно удалить
    public ReviewResponseDto editResponseToReview(ReviewResponseDto reviewResponseDto) throws ParseException {
        boolean isExists = reviewResponseDao.existsById(reviewResponseDto.getId());
        if (!isExists) {
            return null;
        } else {
            ReviewResponse reviewResponse = reviewResponseMapper.reviewResponseDtoToReviewResponse(reviewResponseDto);

            String currentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            Date convertedCurrentDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(currentDate);

            reviewResponse.setReviewResponseDate(convertedCurrentDate);
            return reviewResponseMapper.reviewResponseToReviewResponseDto(reviewResponse);
        }
    }

    @Override
    public ReviewResponseDto deleteResponseToReview(ReviewResponseDto reviewResponseDto) throws ParseException {
        return null;
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
