package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.entity.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCategoryDao extends JpaRepository<RoomCategory, Long> {

}
