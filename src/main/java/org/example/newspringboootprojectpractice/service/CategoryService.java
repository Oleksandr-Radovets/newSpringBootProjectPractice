package org.example.newspringboootprojectpractice.service;

import org.example.newspringboootprojectpractice.dto.Category.CategoryResponseDto;
import org.example.newspringboootprojectpractice.dto.Category.CreateCategoryRequestDto;
import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    CategoryResponseDto getById(Long id);
    CategoryResponseDto save(CreateCategoryRequestDto categoryDto);
    CategoryResponseDto update(Long id, CreateCategoryRequestDto categoryDto);
    void deleteById(Long id);
}
