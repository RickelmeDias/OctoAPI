package com.octopodius.OctoAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryTypeEnum {
    NATURAL_SCIENCES("Natural Sciences"),
    SOCIAL_SCIENCES("Social Sciences"),
    ENGINEERING("Engineering"),
    COMPUTER_SCIENCE("Computer Science"),
    EXACT_SCIENCES("Exact Sciences"),
    ARTS("Arts"),
    OTHER("Other");


    private String name;
}
