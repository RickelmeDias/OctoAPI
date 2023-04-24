package com.octopodius.OctoAPI.daos;

import com.octopodius.OctoAPI.entities.Group;
import com.octopodius.OctoAPI.enums.GroupTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByName(GroupTypeEnum name);
}
