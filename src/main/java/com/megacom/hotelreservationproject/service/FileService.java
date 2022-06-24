package com.megacom.hotelreservationproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    ResponseEntity<?> uploadImageToHotel(MultipartFile file, Long hotelId, int orderNum);

}
