package com.octopodius.OctoAPI.dtos.users.res;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserResDTO(
        @NotNull
        Integer id,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email) {

        public UserResDTO(Integer id, String username, String email) {
                this.id = id;
                this.username = username;
                this.email = email;
        }
}
