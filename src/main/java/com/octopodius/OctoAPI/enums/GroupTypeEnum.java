package com.octopodius.OctoAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupTypeEnum {
    SUPER("SUPER"),
    ADMIN("ADMIN");

    private String name;
}
