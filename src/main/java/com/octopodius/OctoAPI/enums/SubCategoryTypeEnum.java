package com.octopodius.OctoAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubCategoryTypeEnum {
    //      Natural Sciences
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    BIOLOGY("Biology"),
    GEOLOGY("Geology"),
    ASTRONOMY("Astronomy"),
    ECOLOGY("Ecology"),
    ENVIRONMENTAL_SCIENCE("Environmental Science"),
    ZOOLOGY("Zoology"),
    BOTANY("Botany"),
    NEUROSCIENCE("Neuroscience"),

    //      Social Sciences
    ANTHROPOLOGY("Anthropology"),
    ARCHAEOLOGY("Archaeology"),
    ECONOMICS("Economics"),
    HISTORY("History"),
    LAW("Law"),
    LINGUISTICS("Linguistics"),
    PHILOSOPHY("Philosophy"),
    POLITICAL_SCIENCE("Political Science"),
    PSYCHOLOGY("Psychology"),
    SOCIOLOGY("Sociology"),

    //      Humanities

    //      Engineering

    //      Computer Science

    //      Business

    //      Exact Sciences

    //      Arts

    //      Other
    OTHER("Other");

    private String name;
}
