package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Users;
import lombok.Data;

@Data
public class ReviewResponseDto {
    private Long id;
    private String text;
    private Users users;
}
