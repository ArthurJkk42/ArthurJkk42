package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import com.megacom.hotelreservationproject.models.entity.Users;
import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private Users users;
    private Hotel hotel;
    private int score;
    private String text;
    private ReviewResponse reviewResponse;
}
