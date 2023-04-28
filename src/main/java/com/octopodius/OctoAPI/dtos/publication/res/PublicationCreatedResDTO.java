package com.octopodius.OctoAPI.dtos.publication.res;

import com.octopodius.OctoAPI.entities.Publication;
import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;

import java.util.List;

public record PublicationCreatedResDTO(
        Publication.PublicationsId id,
        String title,
        String body,
        String slug,
        CategoryTypeEnum category,
        SubCategoryTypeEnum subCategory,
        List<String> tags
) {
}

