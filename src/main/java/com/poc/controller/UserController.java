package com.poc.controller;

import com.poc.controller.utils.PermissionsAndStatusUtils;
import com.poc.model.dto.UserResponseDTO;
import com.poc.service.application.UserCUDSA;
import com.poc.service.application.UserRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserRSA userRSA;
    private final UserCUDSA userCUDSA;

    @Operation(summary = "WS used to get all users")
    @GetMapping
    @PreAuthorize(PermissionsAndStatusUtils.AUTH_USER)
    public HelpPage<UserResponseDTO> getAllUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRSA.getAllUsers(pageable);
    }

    @Operation(summary = "WS used to get user by id")
    @GetMapping("/{id}")
    @PreAuthorize(PermissionsAndStatusUtils.AUTH_USER)
    public UserResponseDTO getUserById(@PathVariable("id") Long id) {
        return userRSA.getUserById(id);
    }

    @Operation(summary = "WS used to get user by username")
    @GetMapping("/byUsername")
    @PreAuthorize(PermissionsAndStatusUtils.AUTH_USER)
    public UserResponseDTO getUserByUsername(@RequestParam(name = "username", required = true) String username) {
        return userRSA.getUserByUsername(username);
    }

    @Operation(summary = "WS used to delete user by id")
    @DeleteMapping("/{id}")
    @PreAuthorize(PermissionsAndStatusUtils.AUTH_ADMIN)
    public String deleteUserById(@PathVariable("id") Long id) {
        userCUDSA.deleteUserById(id);
        return "User deleted successfully";
    }

}
