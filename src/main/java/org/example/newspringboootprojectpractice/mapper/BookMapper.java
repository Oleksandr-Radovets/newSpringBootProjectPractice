package org.example.newspringboootprojectpractice.mapper;

import org.example.newspringboootprojectpractice.config.MapperConfig;
import org.example.newspringboootprojectpractice.dto.book.BookResponseDto;
import org.example.newspringboootprojectpractice.dto.book.CreateBookRequestDto;
import org.example.newspringboootprojectpractice.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookResponseDto toDto(Book book);
    Book toEntity(CreateBookRequestDto bookDto);
}
