package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_review")
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "guest_id")
    private Users users;
    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private int score;
    private String text;
    @ManyToOne
    @JoinColumn(name = "response_id")
    private ReviewResponse reviewResponse;
}
