package org.example.newspringboootprojectpractice.service;

import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationRequestDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationResponseDto;
import org.example.newspringboootprojectpractice.exeption.RegistrationException;

public interface UserService {
    UserRegistrationResponseDto registerUser(UserRegistrationRequestDto userRegistrationRequestDto) throws RegistrationException;
}
