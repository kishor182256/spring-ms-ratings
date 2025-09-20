package com.hotel.rating.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ratings_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "hotel_id", nullable = false)
    private int hotelId;

    @Column(name = "actual_rating", nullable = false)
    private int actualRating;

    @Column(name = "remarks")
    private String remarks;
}
