package com.service.user.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingEntity {

   private  int ratingId;
   private String userId;
   private String hotelId;
   private int actualRating;
   private String remarks;

   private HotelEntity hotel;

}
