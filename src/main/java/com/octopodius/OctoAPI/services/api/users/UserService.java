package com.octopodius.OctoAPI.services.api.users;

import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;

import java.util.List;

public interface UserService {
    UserRegisterResDTO register(UserRegisterReqDTO userDto);

    List<UserResDTO> getAll();
}
