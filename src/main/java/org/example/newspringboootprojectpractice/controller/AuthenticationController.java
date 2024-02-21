package org.example.newspringboootprojectpractice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationRequestDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationResponseDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserRequestLoginDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserResponseTokenDto;
import org.example.newspringboootprojectpractice.exeption.RegistrationException;
import org.example.newspringboootprojectpractice.security.AuthenticationService;
import org.example.newspringboootprojectpractice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    private AuthenticationService authenticationService;
    private UserService userService;

    @PostMapping("/create")
    public UserRegistrationResponseDto create(@RequestBody
                                                  UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        return userService.registerUser(userRegistrationRequestDto);
    }

    @Operation(summary = "write login user", description = "write login user")
    @PostMapping("/auth/login")
    public UserResponseTokenDto login(@RequestBody UserRequestLoginDto requestDto) {
        return authenticationService.authentication(requestDto);
    }
}
