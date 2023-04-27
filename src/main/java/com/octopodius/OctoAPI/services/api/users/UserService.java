package com.octopodius.OctoAPI.services.api.users;

import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;
import com.octopodius.OctoAPI.entities.User;

import java.util.List;

public interface UserService {
    UserRegisterResDTO createUser(UserRegisterReqDTO userDto);

    List<UserResDTO> getAll();

    void deleteUserByEmail(String email);

    UserResDTO getUserByEmail(String email);

    User getUserInformation();
}
