package com.octopodius.OctoAPI.daos;

import com.octopodius.OctoAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
