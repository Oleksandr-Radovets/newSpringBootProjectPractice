package org.example.newspringboootprojectpractice.dto.userDto;

import lombok.Data;
import lombok.ToString;

@Data
public class UserRegistrationResponseDto {
    @ToString.Exclude
    private Long id;
    @ToString.Exclude
    private String email;
}
