package com.octopodius.OctoAPI.dtos.users.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterReqDTO(
        @NotBlank(message = "username is invalid")
        String username,
        @NotBlank(message = "password is invalid")
        String password,
        @NotBlank(message = "email is invalid")
        @Email(message = "email is invalid")
        String email) {
}
