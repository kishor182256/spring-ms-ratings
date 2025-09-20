package com.hotel.rating.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private int ratingId;
    private int userId;
    private int hotelId;
    private int actualRating;
    private String remarks;
}
