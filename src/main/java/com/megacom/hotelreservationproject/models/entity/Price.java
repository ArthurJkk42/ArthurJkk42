package com.megacom.hotelreservationproject.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_price")
public class Price {
    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
