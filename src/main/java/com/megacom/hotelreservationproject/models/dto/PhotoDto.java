package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import lombok.Data;

@Data
public class PhotoDto {
    private Long id;
    private String photoLink;
    private int orderNum;
    private Hotel hotel;
}
