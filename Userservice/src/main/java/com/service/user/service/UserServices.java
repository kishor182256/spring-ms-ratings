package com.service.user.service;

import com.service.user.dto.UserDTO;
import java.util.List;

public interface UserServices {

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    UserDTO getSingleUser(Long userId);
}
