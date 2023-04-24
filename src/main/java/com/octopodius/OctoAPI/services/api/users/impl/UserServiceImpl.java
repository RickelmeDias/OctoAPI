package com.octopodius.OctoAPI.services.api.users.impl;

import com.octopodius.OctoAPI.daos.GroupRepository;
import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.entities.Group;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.enums.GroupTypeEnum;
import com.octopodius.OctoAPI.services.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResDTO register(UserRegisterReqDTO userDto) {
        final Group defaultGroup = groupRepository.findByName(GroupTypeEnum.USER);
        User user = new User(userDto.username(), passwordEncoder.encode(userDto.password()), userDto.email(), defaultGroup);
        User registredUser = repository.save(user);

        return new UserRegisterResDTO(registredUser.getId(), registredUser.getUsername(), registredUser.getEmail());
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
