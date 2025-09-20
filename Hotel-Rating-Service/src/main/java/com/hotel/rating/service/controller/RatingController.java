package com.hotel.rating.service.controller;


import com.hotel.rating.service.dto.RatingDto;
import com.hotel.rating.service.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingsService;

    public RatingController(RatingService ratingsService) {
        this.ratingsService = ratingsService;
    }

    // Create Rating
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingsDto) {
        RatingDto created = ratingsService.createRating(ratingsDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(ratingsService.getRatingByUserId(userId));
    }


    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<RatingDto> getRatingByHotelId(@PathVariable int hotelId) {
        return ResponseEntity.ok(ratingsService.getRatingByHotelId(hotelId));
    }
    // Get All Ratings
    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        return ResponseEntity.ok(ratingsService.getAllRatings());
    }

    // Update Rating
    @PutMapping("/{id}")
    public ResponseEntity<RatingDto> updateRating(@PathVariable int id, @RequestBody RatingDto ratingsDto) {
        RatingDto updated = ratingsService.updateRating(id, ratingsDto);
        return ResponseEntity.ok(updated);
    }

    // Delete Rating
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable int id) {
        ratingsService.deleteRating(id);
        return ResponseEntity.ok("Rating deleted successfully with id: " + id);
    }
}
