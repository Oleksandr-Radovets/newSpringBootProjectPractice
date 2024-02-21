package org.example.newspringboootprojectpractice.mapper;

import org.example.newspringboootprojectpractice.config.MapperConfig;
import org.example.newspringboootprojectpractice.dto.Category.CategoryResponseDto;
import org.example.newspringboootprojectpractice.dto.Category.CreateCategoryRequestDto;
import org.example.newspringboootprojectpractice.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);
    Category toModel(CreateCategoryRequestDto categoryDTO);
}
