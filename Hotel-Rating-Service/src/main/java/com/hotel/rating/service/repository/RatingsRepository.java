package com.hotel.rating.service.repository;

import com.hotel.rating.service.entity.RatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingsRepository extends JpaRepository<RatingsEntity,Integer> {

    List<RatingsEntity> findByUserId(int userId);
    Optional<RatingsEntity> findByHotelId(int  hotelId);
}
