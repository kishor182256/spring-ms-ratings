package com.hotel.service.controller;

import com.hotel.service.dto.HotelDTO;
import com.hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    // Create new hotel
    @PostMapping("/create-hotel")
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        HotelDTO savedHotel = hotelService.createHotel(hotelDTO);
        return ResponseEntity.ok(savedHotel);
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    // Get single hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getSingleHotel(@PathVariable("id") Integer hotelId) {
        return ResponseEntity.ok(hotelService.getSingleHotel(hotelId));
    }
}
