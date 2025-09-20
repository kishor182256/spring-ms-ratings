package com.service.user.service.impl;

import com.service.user.dto.RatingDTO;
import com.service.user.dto.UserDTO;
import com.service.user.exception.DuplicateResourceException;
import com.service.user.exception.ResourceNotFoundException;
import com.service.user.model.HotelEntity;
import com.service.user.model.UserEntity;
import com.service.user.repository.UserRepository;
import com.service.user.service.UserServices;
import com.service.user.service.external.HotelServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServiceFeignClient hotelServiceFeignClient;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        Optional<UserEntity> email = userRepository.findByEmail(userDTO.getEmail());
        if (email.isPresent()) {
            throw new DuplicateResourceException("Email already exists: " + userDTO.getEmail());
        }
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getSingleUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        ResponseEntity<List<RatingDTO>> forEntity =
                restTemplate.exchange(
                        "http://HOTEL-RATING-SERVICE/api/ratings/user/"+user.getId(),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<RatingDTO>>() {}
                );
        List<RatingDTO> ratings = forEntity.getBody();
        List<RatingDTO> ratingList = ratings.stream().map(rating -> {
//            ResponseEntity<HotelEntity> hotelRatings = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), HotelEntity.class);
//            HotelEntity hotel = hotelRatings.getBody();
            int hotelId = Integer.parseInt(rating.getHotelId());
            HotelEntity hotel = hotelServiceFeignClient.getHotel(hotelId);
            System.out.println("hotelsDetails===> " + hotel);
            rating.setHotelDetails(hotel);
            return rating;
        }).toList();
//        System.out.println("===> " + ratings);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        // manually set ratings
        userDTO.setHotelRating(ratingList);

        return userDTO;
    }
}
