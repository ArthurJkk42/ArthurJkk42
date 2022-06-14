package com.megacom.hotelreservationproject.controllers;

import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/delete")
    public HotelDto delete(@RequestBody HotelDto hotelDto) {
        return hotelService.delete(hotelDto);
    }
}
