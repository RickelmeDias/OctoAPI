package com.octopodius.OctoAPI.dtos.publication.res;

public record PublicationCreatedResDTO(
        String id,
        String title,
        String body,
        String category,
        String subCategory,
        String tags
) {
}

