package com.megacom.hotelreservationproject.service.impl;

import com.megacom.hotelreservationproject.dao.PriceDao;
import com.megacom.hotelreservationproject.mappers.PriceMapper;
import com.megacom.hotelreservationproject.models.dto.PriceDto;
import com.megacom.hotelreservationproject.models.entity.Price;
import com.megacom.hotelreservationproject.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceDao priceDao;

    private PriceMapper priceMapper = PriceMapper.INSTANCE;

    @Override
    public PriceDto save(PriceDto priceDto) {
        Price price = priceMapper.priceDtoToPrice(priceDto);
        Price priceSaved = priceDao.save(price);
        return priceMapper.priceToPriceDto(priceSaved);
    }

    @Override
    public PriceDto findById(Long id) {
        Price price = priceDao.findById(id).orElse(null);
        return priceMapper.priceToPriceDto(price);
    }

    @Override
    public PriceDto findByRoomId(Long id) {
        return null;
    }

    @Override
    public PriceDto findByGuestId(Long id) {
        return null;
    }

    @Override
    public PriceDto update(PriceDto priceDto) {
        boolean isExists = priceDao.existsById(priceDto.getId());
        if (!isExists) {
            return null;
        } else {
            Price price = priceMapper.priceDtoToPrice(priceDto);
            Price updatedPrice = priceDao.save(price);
            return priceMapper.priceToPriceDto(price);
        }
    }

    @Override
    public List<PriceDto> findPricesByHotel(Long id) {
        return null;
    }

    @Override
    public List<PriceDto> findPricesByCity() {
        return null;
    }
}
