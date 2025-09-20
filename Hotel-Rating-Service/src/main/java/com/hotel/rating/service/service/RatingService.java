package com.hotel.rating.service.service;

import com.hotel.rating.service.dto.RatingDto;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingDto ratingsDto);

    List<RatingDto> getRatingByUserId(int userId);

    RatingDto getRatingByHotelId(int hotelId);

    List<RatingDto> getAllRatings();

    RatingDto updateRating(int ratingId, RatingDto ratingsDto);

    void deleteRating(int ratingId);

}
