package com.service.user.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelEntity {

    private int hotelId;
    private String hotelName;
    private String location;
}
