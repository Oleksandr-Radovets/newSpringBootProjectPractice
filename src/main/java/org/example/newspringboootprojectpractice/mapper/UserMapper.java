package org.example.newspringboootprojectpractice.mapper;


import org.example.newspringboootprojectpractice.config.MapperConfig;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationRequestDto;
import org.example.newspringboootprojectpractice.dto.userDto.UserRegistrationResponseDto;
import org.example.newspringboootprojectpractice.model.User;
import org.mapstruct.Mapper;

@Mapper (config = MapperConfig.class)
public interface UserMapper {
    User toModel (UserRegistrationRequestDto requestDto);

    UserRegistrationResponseDto toDto (User user);
}
