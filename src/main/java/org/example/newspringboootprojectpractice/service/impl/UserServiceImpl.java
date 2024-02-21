package org.example.newspringboootprojectpractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationRequestDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationResponseDto;
import org.example.newspringboootprojectpractice.exeption.RegistrationException;
import org.example.newspringboootprojectpractice.mapper.UserMapper;
import org.example.newspringboootprojectpractice.model.User;
import org.example.newspringboootprojectpractice.repository.UserRepository;
import org.example.newspringboootprojectpractice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationResponseDto registerUser(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(userRegistrationRequestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Unable to complete registration.");
        }
        User user = userMapper.toModel(userRegistrationRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toDto(userRepository.save(user));
    }
}
