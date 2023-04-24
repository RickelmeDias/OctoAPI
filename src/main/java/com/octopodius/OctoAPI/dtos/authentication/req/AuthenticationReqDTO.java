package com.octopodius.OctoAPI.dtos.authentication.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationReqDTO(
        @NotBlank(message = "email is invalid")
        @Email
        String email,
        @NotBlank(message = "password is invalid")
        String password){
}
