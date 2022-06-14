package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.Room;
import com.megacom.hotelreservationproject.models.entity.User;
import com.megacom.hotelreservationproject.models.enums.EBookingStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDto {
    private Long id;
    private Hotel hotel;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private User user;
    private String comment;
    private EBookingStatus status;
    private double sum;
}
