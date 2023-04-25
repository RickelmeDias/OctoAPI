package com.octopodius.OctoAPI.dtos.publication.res;

import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;
import com.octopodius.OctoAPI.utils.EnumValidators.ValueOfEnum;
import jakarta.validation.constraints.NotBlank;

public record PublicationCreatedResDTO(
        String id,
        String title,
        String body,
        String category,

        String subCategory,
        String tags
) {
}

