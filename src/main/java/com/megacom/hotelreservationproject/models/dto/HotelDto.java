package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.City;
import lombok.Data;

import java.awt.*;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private Image photos;
    private String phone;
    private String email;
    private City city;
}
