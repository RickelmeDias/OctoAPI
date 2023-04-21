package com.octopodius.OctoAPI.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email) {
}
