package com.poc.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.poc.model.constant.ERole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RoleDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ERole name;
}
