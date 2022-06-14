package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Booking;
import com.megacom.hotelreservationproject.models.entity.User;
import com.megacom.hotelreservationproject.models.enums.EBookingStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BookingHistoryDto {
    private Long id;
    private Booking booking;
    private Date changeDate;
    private String comment;
    private User user;
    private Date checkInDate;
    private Date checkOutDate;
    private User guest;
    private EBookingStatus status;
    private double sum;
}
