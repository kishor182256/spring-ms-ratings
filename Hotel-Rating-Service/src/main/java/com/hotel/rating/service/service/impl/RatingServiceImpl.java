package com.hotel.rating.service.service.impl;

import com.hotel.rating.service.dto.RatingDto;
import com.hotel.rating.service.entity.RatingsEntity;
import com.hotel.rating.service.repository.RatingsRepository;
import com.hotel.rating.service.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingsRepository ratingsRepository;
    private final ModelMapper modelMapper;

    public RatingServiceImpl(RatingsRepository ratingsRepository, ModelMapper modelMapper) {
        this.ratingsRepository = ratingsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RatingDto createRating(RatingDto ratingsDto) {
       RatingsEntity entity = modelMapper.map(ratingsDto, RatingsEntity.class);
        RatingsEntity saved = ratingsRepository.save(entity);
        return modelMapper.map(saved, RatingDto.class);
    }



    @Override
    public List<RatingDto> getRatingByUserId(int userId) {
        List<RatingsEntity> entities = ratingsRepository.findByUserId(userId);
        if (entities.isEmpty()) {
            throw new RuntimeException("No ratings found for userId: " + userId);
        }
        return entities.stream()
                .map(entity -> modelMapper.map(entity, RatingDto.class))
                .toList();
    }


    @Override
    public RatingDto getRatingByHotelId(int hotelId) {
        RatingsEntity entity = ratingsRepository.findByHotelId(Integer.parseInt(String.valueOf(hotelId)))
                .orElseThrow(() -> new RuntimeException("Rating not found for hotelId: " + hotelId));
        return modelMapper.map(entity, RatingDto.class);
    }




    @Override
    public List<RatingDto> getAllRatings() {
        return ratingsRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, RatingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto updateRating(int ratingId, RatingDto ratingsDto) {
        RatingsEntity entity = ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + ratingId));

        // Update fields
        entity.setUserId(Integer.parseInt(String.valueOf(ratingsDto.getUserId())));
        entity.setHotelId(Integer.parseInt(String.valueOf(ratingsDto.getHotelId())));
        entity.setActualRating(ratingsDto.getActualRating());
        entity.setRemarks(ratingsDto.getRemarks());

        RatingsEntity updated = ratingsRepository.save(entity);
        return modelMapper.map(updated, RatingDto.class);
    }

    @Override
    public void deleteRating(int ratingId) {
        RatingsEntity entity = ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + ratingId));
        ratingsRepository.delete(entity);
    }
}
