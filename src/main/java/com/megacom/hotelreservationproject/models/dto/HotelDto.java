package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.City;
import com.megacom.hotelreservationproject.models.entity.Photo;
import lombok.Data;


@Data
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private boolean isActive;
    private City city;
    private double currentScore;
}
