package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import com.megacom.hotelreservationproject.models.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {
    private Long id;
    private User user;
    private Hotel hotel;
    private double score;
    private String text;
    private ReviewResponse reviewResponse;
    private Date reviewDate;
}
