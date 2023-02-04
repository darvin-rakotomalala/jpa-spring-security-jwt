package com.poc.service.business;

import com.poc.model.domain.User;

public interface UserCUDSM {
    User saveUser(User user);
    void deleteUserById(Long id);
}
