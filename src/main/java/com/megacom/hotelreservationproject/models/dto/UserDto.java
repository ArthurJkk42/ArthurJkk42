package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.enums.EUserStatus;
import com.megacom.hotelreservationproject.models.enums.EUserType;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private EUserType userType;
    private EUserStatus userStatus;
}
