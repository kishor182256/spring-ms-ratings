package com.hotel.service.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {

    private int hotelId;
    private String hotelName;
    private String location;

}
