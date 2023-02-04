package com.poc.service.application;

import com.poc.constraint.validation.EmailValidator;
import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.RoleMapper;
import com.poc.mapper.UserMapper;
import com.poc.mapper.UserResponseMapper;
import com.poc.model.constant.ERole;
import com.poc.model.domain.Role;
import com.poc.model.dto.RoleDTO;
import com.poc.model.dto.SignupRequestDTO;
import com.poc.model.dto.UserDTO;
import com.poc.model.dto.UserResponseDTO;
import com.poc.service.business.RoleSM;
import com.poc.service.business.UserCUDSM;
import com.poc.service.business.UserRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserCUDSAImpl implements UserCUDSA {

    private final UserCUDSM userCUDSM;
    private final UserRSM userSM;
    private final RoleSM roleSM;
    private final UserMapper userMapper;
    private final UserResponseMapper userResponseMapper;
    private final RoleMapper roleMapper;
    private final PasswordEncoder encoder;
    private final EmailValidator emailValidator;

    @Override
    public UserResponseDTO registerUser(SignupRequestDTO userDto) {

        if (Boolean.TRUE.equals(userSM.existsByUsername(userDto.getUsername()))) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_USERNAME_EXIST.getErrorMessage());
        }

        boolean isValidEmail = emailValidator.
                isValid(userDto.getEmail());
        if (!isValidEmail) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_EMAIL_INVALID.getErrorMessage());
        }

        if (Boolean.TRUE.equals(userSM.existsByEmail(userDto.getEmail()))) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_EMAIL_EXIST.getErrorMessage());
        }

        // Create new user's account
        UserDTO newUser = new UserDTO();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(encoder.encode(userDto.getPassword()));

        Set<String> strRoles = userDto.getRoles();
        Set<RoleDTO> roles = new HashSet<>();

        if (strRoles.isEmpty()) {
            Role roleUser = new Role();
            roleUser.setName(ERole.ROLE_USER);
            roles.add(roleMapper.toDTO(roleUser));
        } else {
            strRoles.forEach(role -> {
                RoleDTO otherRole = roleMapper.toDTO(roleSM.getRoleByName(ERole.valueOf(role)));
                roles.add(otherRole);
            });
        }
        newUser.setRoles(roles);

        return userResponseMapper.toDTO(userCUDSM.saveUser(userMapper.toDO(newUser)));
    }

    @Override
    public void deleteUserById(Long id) {
        userCUDSM.deleteUserById(id);
    }

}
