package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.entity.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewResponseDao extends JpaRepository<ReviewResponse, Long> {
}
