package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.enums.EBedType;
import com.megacom.hotelreservationproject.models.enums.ERoomType;
import com.megacom.hotelreservationproject.models.enums.EView;
import lombok.Data;

@Data
public class RoomDto {
    private Long id;

    private long capacity;
    private EBedType bedType;
    private String square;
    private boolean wifi;
    private EView view;
    private Hotel hotel;
    private ERoomType type;
}
