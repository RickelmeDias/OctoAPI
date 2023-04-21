package com.octopodius.OctoAPI.services.users.api.users.impl;

import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.users.UserRegisterDTO;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.services.users.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public void register(UserRegisterDTO userDto) {
        User user = new User(userDto.username(), userDto.password(), userDto.email());
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
