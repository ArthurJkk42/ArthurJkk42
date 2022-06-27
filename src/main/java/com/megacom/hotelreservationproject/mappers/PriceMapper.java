package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price priceDtoToPrice(com.megacom.hotelreservationproject.models.dto.PriceDto priceDto);

    com.megacom.hotelreservationproject.models.dto.PriceDto priceToPriceDto(Price price);

    List<Price> priceDtoListToPriceList(List<com.megacom.hotelreservationproject.models.dto.PriceDto> priceDtoList);

    List<com.megacom.hotelreservationproject.models.dto.PriceDto> priceListToPriceDtoList(List<Price> priceList);
}
