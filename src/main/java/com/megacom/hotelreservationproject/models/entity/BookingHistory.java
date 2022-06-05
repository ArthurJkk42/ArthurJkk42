package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_booking_history")
public class BookingHistory {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private Date changeDate;
    private String comment;
}
