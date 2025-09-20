package com.hotel.service.service.impl;

import com.hotel.service.dto.HotelDTO;
import com.hotel.service.entity.HotelEntity;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = modelMapper.map(hotelDTO, HotelEntity.class);
        HotelEntity savedEntity = hotelRepository.save(hotelEntity);
        return modelMapper.map(savedEntity, HotelDTO.class);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO getSingleHotel(int hotelId) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }
}
