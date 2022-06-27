package com.megacom.hotelreservationproject.models.dto;

import com.megacom.hotelreservationproject.models.enums.ERoomType;
import lombok.Data;

@Data
public class RoomCategoryDto {
    private Long id;
    private ERoomType roomType;
}
