package com.poc.service.business;

import com.poc.model.constant.ERole;
import com.poc.model.domain.Role;

public interface RoleSM {
    Role getRoleByName(ERole name);
}
