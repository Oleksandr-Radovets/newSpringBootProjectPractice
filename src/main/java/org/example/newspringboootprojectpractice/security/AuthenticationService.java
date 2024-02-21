package org.example.newspringboootprojectpractice.security;

import org.example.newspringboootprojectpractice.dto.userDto.UserRequestLoginDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserResponseTokenDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    public UserResponseTokenDto authentication(UserRequestLoginDto userRequestLoginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        userRequestLoginDto.email(),
                        userRequestLoginDto.password()));
        String token = jwtUtil.generationToken(authentication.getName());
        return new UserResponseTokenDto(token);
    }
}
