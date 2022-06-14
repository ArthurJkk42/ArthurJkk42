package com.megacom.hotelreservationproject.dao;

import com.megacom.hotelreservationproject.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
