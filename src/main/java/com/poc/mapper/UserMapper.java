package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.User;
import com.poc.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends DtoMapper<UserDTO, User> {

}
