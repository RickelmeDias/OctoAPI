package com.octopodius.OctoAPI.dtos.users.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterReqDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email) {
}
