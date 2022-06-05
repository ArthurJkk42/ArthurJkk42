package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.ReviewResponseDto;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReviewResponseMapper {

    ReviewResponseMapper INSTANCE = Mappers.getMapper(ReviewResponseMapper.class);

    ReviewResponse reviewResponseDtoToReviewResponse(ReviewResponseDto reviewResponseDto);

    ReviewResponseDto reviewResponseToReviewResponseDto(ReviewResponse reviewResponse);

    List<ReviewResponse> reviewResponseDtoListToReviewResponseList(List<ReviewResponseDto> reviewResponseDtoList);

    List<ReviewResponseDto> reviewResponseListToReviewResponseDtoList(List<ReviewResponse> reviewResponseList);
}
