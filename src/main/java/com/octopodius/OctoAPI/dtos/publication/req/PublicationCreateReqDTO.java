package com.octopodius.OctoAPI.dtos.publication.req;

import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;
import com.octopodius.OctoAPI.utils.EnumValidators.ValueOfEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PublicationCreateReqDTO (
        @NotBlank(message = "title is invalid")
        String title,

        @NotBlank(message = "body is invalid")
        String body,

        @NotBlank(message = "slug is invalid")
        String slug,

        @ValueOfEnum(enumClass = CategoryTypeEnum.class, message = "category is invalid")
        CategoryTypeEnum category,

        @ValueOfEnum(enumClass = SubCategoryTypeEnum.class, message = "category is invalid")
        SubCategoryTypeEnum subCategory,

        List<String> tags
) {
}

