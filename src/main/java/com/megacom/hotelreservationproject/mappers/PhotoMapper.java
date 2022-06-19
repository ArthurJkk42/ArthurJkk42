package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.PhotoDto;
import com.megacom.hotelreservationproject.models.entity.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhotoMapper {

    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    Photo photoDtoToPhoto(PhotoDto photoDto);

    PhotoDto photoToPhotoDto(Photo photo);

    List<Photo> PhotoDtoListToPhotoList(List<PhotoDto> photoDtoList);

    List<PhotoDto> photoListToPhotoDtoList(List<Photo> photoList);

}
