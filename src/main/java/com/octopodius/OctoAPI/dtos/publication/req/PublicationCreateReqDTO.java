package com.octopodius.OctoAPI.dtos.publication.req;

import com.octopodius.OctoAPI.enums.CategoryTypeEnum;
import com.octopodius.OctoAPI.enums.SubCategoryTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record PublicationCreateReqDTO (
        @NotBlank(message = "title is invalid")
        String title,

        @NotBlank(message = "body is invalid")
        String body,

        @NotBlank(message = "slug is invalid")
        String slug,

        @NotNull
        CategoryTypeEnum category,

        @NotNull
        SubCategoryTypeEnum subCategory,

        List<String> tags
) {
}

