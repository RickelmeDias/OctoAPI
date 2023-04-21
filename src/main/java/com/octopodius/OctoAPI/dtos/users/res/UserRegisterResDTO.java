package com.octopodius.OctoAPI.dtos.users.res;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterResDTO(
        @NotNull
        Integer id,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email) {
}
