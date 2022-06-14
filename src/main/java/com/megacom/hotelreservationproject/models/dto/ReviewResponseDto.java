package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewResponseDto {
    private Long id;
    private String text;
    private User user;
    private Date reviewResponseDate;
}
