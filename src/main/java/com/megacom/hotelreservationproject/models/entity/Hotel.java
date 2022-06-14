package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String address;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photos;
    private String phone;
    private String email;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private double currentScore;
}
