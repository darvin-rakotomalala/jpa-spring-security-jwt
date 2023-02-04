package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Role;
import com.poc.model.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper extends DtoMapper<RoleDTO, Role> {

}
