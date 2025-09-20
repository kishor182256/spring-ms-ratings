package com.service.user.dto;

import com.service.user.model.RatingEntity;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<RatingDTO> hotelRating;
}
