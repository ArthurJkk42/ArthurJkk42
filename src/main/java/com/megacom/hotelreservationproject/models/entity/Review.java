package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_review")
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "guest_id")
    private User guest;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private double score;
    private String text;
    @OneToOne
    @JoinColumn(name = "response_id")
    private ReviewResponse reviewResponse;
    private Date reviewDate;
}
