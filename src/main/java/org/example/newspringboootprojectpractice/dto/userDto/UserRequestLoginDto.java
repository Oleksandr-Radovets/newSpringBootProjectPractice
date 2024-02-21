package org.example.newspringboootprojectpractice.dto.userDto;

import jakarta.validation.constraints.*;

public record UserRequestLoginDto(
        @NotEmpty
        @Size(min = 6, max = 50)
        @Email
        String email,
        @NotBlank
        @Size(min = 6, max = 50)
        String password) {
}
