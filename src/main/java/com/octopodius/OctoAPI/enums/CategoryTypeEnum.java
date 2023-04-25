package com.octopodius.OctoAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryTypeEnum {
    NATURAL_SCIENCES("Natural Sciences"),
    SOCIAL_SCIENCES("Social Sciences"),
    HUMANITIES("Humanities"),
    ENGINEERING("Engineering"),
    COMPUTER_SCIENCE("Computer Science"),
    BUSINESS("Business"),
    EXACT_SCIENCES("Exact Sciences"),
    ARTS("Arts"),
    OTHER("Other");


    private String name;
}
