package com.octopodius.OctoAPI.services.api.users.impl;

import com.octopodius.OctoAPI.daos.GroupRepository;
import com.octopodius.OctoAPI.daos.UserRepository;
import com.octopodius.OctoAPI.dtos.users.req.UserRegisterReqDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserRegisterResDTO;
import com.octopodius.OctoAPI.dtos.users.res.UserResDTO;
import com.octopodius.OctoAPI.entities.Group;
import com.octopodius.OctoAPI.entities.User;
import com.octopodius.OctoAPI.enums.GroupTypeEnum;
import com.octopodius.OctoAPI.services.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserRegisterResDTO createUser(UserRegisterReqDTO userDto) {
        User user = new User(userDto.username(), passwordEncoder.encode(userDto.password()), userDto.email(), groupRepository.findByName(GroupTypeEnum.USER));
        User registredUser = repository.save(user);
        return new UserRegisterResDTO(registredUser.getId(), registredUser.getUsername(), registredUser.getEmail());
    }

    @Override
    public List<UserResDTO> getAll() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> new UserResDTO(user.getId(), user.getUsername(), user.getEmail())).collect(Collectors.toList());
    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = (User) repository.findByEmail(email);
        Group deletedGroup = groupRepository.findByName(GroupTypeEnum.DELETED);
        user.deleteUserAndRemoveGroup(deletedGroup);
    }
}
