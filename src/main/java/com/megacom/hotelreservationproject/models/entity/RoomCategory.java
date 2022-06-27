package com.megacom.hotelreservationproject.models.entity;

import com.megacom.hotelreservationproject.models.enums.ERoomType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_room_category")
public class RoomCategory {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ERoomType roomType;
}
