package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Booking;
import lombok.Data;

import java.util.Date;

@Data
public class BookingHistoryDto {
    private Long id;
    private Booking booking;
    private Date changeDate;
    private String comment;
}
