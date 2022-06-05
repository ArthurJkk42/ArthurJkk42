package com.megacom.hotelreservationproject.models.entity;

import com.megacom.hotelreservationproject.models.enums.EBedType;
import com.megacom.hotelreservationproject.models.enums.ERoomType;
import com.megacom.hotelreservationproject.models.enums.EView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_room")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private long capacity;
    private EBedType bedType;
    private String square;
    private boolean wifi;
    private EView view;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private ERoomType type;
}
