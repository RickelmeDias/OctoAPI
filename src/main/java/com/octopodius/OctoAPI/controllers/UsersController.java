package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.services.api.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    @Transactional
    public ResponseEntity<UserRegisterResDTO> register(@RequestBody @Valid UserRegisterReqDTO userDto, UriComponentsBuilder uriBuilder) {
        UserRegisterResDTO userResponse = service.register(userDto);
        final URI uri = uriBuilder.path("/users/{id}").buildAndExpand(userResponse.id()).toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }

    @GetMapping
    @Transactional
    List<UserResDTO> getAll() {
        return service.getAll();
    }
}
