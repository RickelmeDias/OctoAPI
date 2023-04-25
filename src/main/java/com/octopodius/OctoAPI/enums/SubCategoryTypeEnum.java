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
    LITERATURE("Literature"),

    //      Engineering
    CIVIL_ENGINEERING("Civil Engineering"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    CHEMICAL_ENGINEERING("Chemical Engineering"),
    COMPUTER_ENGINEERING("Computer Engineering"),
    AEROSPACE_ENGINEERING("Aerospace Engineering"),
    BIOMEDICAL_ENGINEERING("Biomedical Engineering"),
    ENVIRONMENTAL_ENGINEERING("Environmental Engineering"),
    MATERIALS_SCIENCE_AND_ENGINEERING("Materials Science and Engineering"),
    PETROLEUM_ENGINEERING("Petroleum Engineering"),

    //      Computer Science
    COMPUTER_PROGRAMMING("Computer Programming"),
    COMPUTER_NETWORKS("Computer Networks"),
    COMPUTER_ARCHITECTURE("Computer Architecture"),
    DATABASE_MANAGEMENT("Database Management"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence"),
    COMPUTER_GRAPHICS("Computer Graphics"),
    OPERATING_SYSTEMS("Operating Systems"),
    CYBER_SECURITY("Cyber Security"),
    COMPUTER_VISION("Computer Vision"),
    ALGORITHMS("Algorithms"),
    DATA_STRUCTURES("Data Structures"),
    MACHINE_LEARNING("Machine Learning"),
    WEB_DEVELOPMENT("Web Development"),
    NATURAL_LANGUAGE_PROCESSING("Natural Language Processing"),
    ROBOTICS("Robotics"),
    SOFTWARE_TESTING("Software Testing"),
    WEB_SERVICES("Web Services"),

    //      Exact Sciences
    MATHEMATICS("Mathematics"),
    STATISTICS("Statistics"),
    MATERIALS_SCIENCE("Materials Science"),
    GEOSCIENCES("Geosciences"),
    OPERATIONS_RESEARCH("Operations Research"),
    APPLIED_MATHEMATICS("Applied Mathematics"),
    THEORETICAL_PHYSICS("Theoretical Physics"),
    ALGEBRA("Algebra"),
    ANALYSIS("Analysis"),
    GEOMETRY("Geometry"),
    TRIGONOMETRY("Trigonometry"),
    CALCULUS("Calculus"),
    DIFFERENTIAL_EQUATIONS("Differential Equations"),
    NUMBER_THEORY("Number Theory"),
    COMPLEX_ANALYSIS("Complex Analysis"),
    TOPOLOGY("Topology"),
    PROBABILITY_THEORY("Probability Theory"),

    //      Arts
    ART_HISTORY("Art History"),
    ART("Art"),
    MUSIC("Music"),
    THEATRE("Theatre"),

    //      Other
    OTHER("Other");

    private String name;
}
