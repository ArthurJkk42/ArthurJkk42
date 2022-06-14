package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDao extends JpaRepository<Price, Long> {
}
