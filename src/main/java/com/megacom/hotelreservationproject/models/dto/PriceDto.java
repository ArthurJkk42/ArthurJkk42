package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Room;
import lombok.Data;

import java.util.Date;

@Data
public class PriceDto {
    private Long id;
    private String price;
    private Date startDate;
    private Date endDate;
    private Room room;
}
