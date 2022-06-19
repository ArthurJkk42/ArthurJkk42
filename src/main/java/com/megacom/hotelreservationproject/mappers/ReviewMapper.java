package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.ReviewDto;
import com.megacom.hotelreservationproject.models.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review reviewDtoToReview(ReviewDto reviewDto);

    ReviewDto reviewToReviewDto(Review review);

    List<Review> reviewDtoListToReviewList(List<ReviewDto> reviewDtoList);

    List<ReviewDto> reviewListToReviewDtoList(List<Review> reviewList);
}
