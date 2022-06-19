package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.PhotoDao;
import com.megacom.hotelreservationproject.mappers.HotelMapper;
import com.megacom.hotelreservationproject.mappers.PhotoMapper;
import com.megacom.hotelreservationproject.models.dto.HotelDto;
import com.megacom.hotelreservationproject.models.dto.PhotoDto;
import com.megacom.hotelreservationproject.models.entity.Hotel;
import com.megacom.hotelreservationproject.models.entity.Photo;
import com.megacom.hotelreservationproject.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired private PhotoDao photoDao;

    private HotelMapper hotelMapper = HotelMapper.INSTANCE;
    private PhotoMapper photoMapper = PhotoMapper.INSTANCE;

    @Override
    public PhotoDto findById(Long id) {
        Photo photo = photoDao.findById(id).orElse(null);
        return photoMapper.photoToPhotoDto(photo);
    }

    @Override
    public List<PhotoDto> findAllPhotosByHotel(Hotel hotel) {
        List<Photo> photoList = photoDao.findAllPhotoByHotel(hotel);
        return photoMapper.photoListToPhotoDtoList(photoList);
    }

    @Override
    public String findMainPhoto(Hotel hotel) {
        List<PhotoDto> photoListDto = findAllPhotosByHotel(hotel);
        List<Photo> photoList = photoMapper.PhotoDtoListToPhotoList(photoListDto);

        photoList.stream().forEach(x -> {
            List<Integer> orderNumList = new ArrayList<>();
            for (int i : orderNumList) {
                orderNumList.add(x.getOrderNum());
            }
            int mainPhotoNum = Collections.min(orderNumList);
            if (x.getOrderNum() != mainPhotoNum) {
                photoList.remove(x);
            }
        });
        String mainPhotoLink = photoList.stream().findFirst().get().getPhotoLink();
        return mainPhotoLink;
    }
}
