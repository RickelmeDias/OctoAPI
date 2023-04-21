package com.octopodius.OctoAPI.services.users.api.users;

import com.octopodius.OctoAPI.dtos.users.UserRegisterDTO;
import com.octopodius.OctoAPI.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void register(UserRegisterDTO userDto);

    List<User> getAll();
}
