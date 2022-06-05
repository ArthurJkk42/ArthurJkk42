package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_review_response")
public class ReviewResponse {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @ManyToOne
    private Users users;
}
