package com.poc.service.application;

import com.poc.model.dto.SignupRequestDTO;
import com.poc.model.dto.UserResponseDTO;

public interface UserCUDSA {
    UserResponseDTO registerUser(SignupRequestDTO userDto);
    void deleteUserById(Long id);
}
