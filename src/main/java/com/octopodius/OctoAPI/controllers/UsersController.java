package com.octopodius.OctoAPI.controllers;

import com.octopodius.OctoAPI.dtos.users.UserRegisterDTO;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.services.users.api.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    UserService service;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid UserRegisterDTO userDto) {
        service.register(userDto);
    }

    @GetMapping
    @Transactional
    List<User> getAll() {
        return service.getAll();
    }
}
