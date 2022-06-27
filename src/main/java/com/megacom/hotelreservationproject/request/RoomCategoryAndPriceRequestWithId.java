package com.megacom.hotelreservationproject.request;

import com.megacom.hotelreservationproject.models.enums.ERoomType;
import lombok.Data;

import java.util.Date;

@Data
public class RoomCategoryAndPriceRequestWithId {
    private Long roomCategoryId;
    private ERoomType roomType;

    private double price;
    private Date startDate;
    private Date endDate;
}
