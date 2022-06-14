package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.dto.CityDto;
import com.megacom.hotelreservationproject.models.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City, Long> {
}
