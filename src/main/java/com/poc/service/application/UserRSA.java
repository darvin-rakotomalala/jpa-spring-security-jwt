package com.poc.service.application;

import com.poc.model.dto.UserResponseDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

public interface UserRSA {
    UserResponseDTO getUserById(Long id);
    UserResponseDTO getUserByUsername(String username);
    HelpPage<UserResponseDTO> getAllUsers(Pageable pageable);
}
