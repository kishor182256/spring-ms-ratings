package com.hotel.service.service;


import com.hotel.service.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    HotelDTO createHotel(HotelDTO hotelDTO);

    List<HotelDTO> getAllHotels();

    HotelDTO getSingleHotel(int hotelId);


}
