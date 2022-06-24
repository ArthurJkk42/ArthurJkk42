package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService {
    @Override
    public ResponseEntity<?> uploadImageToHotel(MultipartFile file, Long hotelId, int orderNum) {
        return null;
    }
}
