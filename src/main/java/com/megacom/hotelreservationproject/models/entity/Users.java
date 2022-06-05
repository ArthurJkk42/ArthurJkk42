package com.megacom.hotelreservationproject.models.entity;

import com.megacom.hotelreservationproject.models.enums.EUserStatus;
import com.megacom.hotelreservationproject.models.enums.EUserType;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_users")
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private EUserType userType;
    private EUserStatus status;
}
