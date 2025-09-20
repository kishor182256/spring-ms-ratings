package com.service.user.dto;


import com.service.user.model.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingDTO {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int actualRating;
    private String remarks;
    private HotelEntity hotelDetails;
}
