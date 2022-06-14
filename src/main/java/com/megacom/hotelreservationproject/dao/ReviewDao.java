package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {
}
