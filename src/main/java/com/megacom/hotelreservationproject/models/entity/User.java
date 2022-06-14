package com.megacom.hotelreservationproject.models.entity;

import com.megacom.hotelreservationproject.models.enums.EUserStatus;
import com.megacom.hotelreservationproject.models.enums.EUserType;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private EUserType userType;
    @Enumerated(value = EnumType.STRING)
    private EUserStatus userStatus;
}
