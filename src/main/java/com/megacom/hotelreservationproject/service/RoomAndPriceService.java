package com.megacom.hotelreservationproject.service;

import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequest;
import com.megacom.hotelreservationproject.request.RoomCategoryAndPriceRequestWithId;

import java.util.List;

public interface RoomAndPriceService {

    List<Object> save(RoomCategoryAndPriceRequest roomAndPriceRequest);

    List<Object> updateRoomCategory(RoomCategoryAndPriceRequestWithId roomAndPriceRequestWithId);
}
