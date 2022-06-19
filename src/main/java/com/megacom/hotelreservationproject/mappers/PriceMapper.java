package com.megacom.hotelreservationproject.mappers;

import com.megacom.hotelreservationproject.models.dto.PriceDto;
import com.megacom.hotelreservationproject.models.entity.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price priceDtoToPrice(PriceDto priceDto);

    PriceDto priceToPriceDto(Price price);

    List<Price> priceDtoListToPriceList(List<PriceDto> priceDtoList);

    List<PriceDto> priceListToPriceDtoList(List<Price> priceList);
}
