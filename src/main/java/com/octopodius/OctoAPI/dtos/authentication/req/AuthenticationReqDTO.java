package com.octopodius.OctoAPI.dtos.authentication.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationReqDTO(
        @NotBlank(message = "username is invalid")
        String username,
        @NotBlank(message = "password is invalid")
        String password){
}
