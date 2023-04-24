package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.security.jwt.JwtTokenService;
import com.octopodius.OctoAPI.services.api.users.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService service;

    @Autowired
    JwtTokenService jwtTokenService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserRegisterResDTO> createUser (@RequestBody @Valid UserRegisterReqDTO userDto, UriComponentsBuilder uriBuilder) {
        UserRegisterResDTO userResponse = service.createUser(userDto);
        final URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userResponse.id()).toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }

    @DeleteMapping
    @Transactional
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<?> deleteUser () {
        String email = jwtTokenService.getUserEmail();
        service.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Transactional
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<List<UserResDTO>> getAllUsers() {
        return ResponseEntity.ok(service.getAll());
    }

}
