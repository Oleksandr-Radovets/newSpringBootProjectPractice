package org.example.newspringboootprojectpractice.service;

import org.example.newspringboootprojectpractice.dto.book.BookResponseDto;
import org.example.newspringboootprojectpractice.dto.book.CreateBookRequestDto;
import java.awt.print.Pageable;
import java.util.List;

public interface BookService {
    List<BookResponseDto> findAllByCategoryId(Long categoryId);

    void deleteBookById(Long id);
    BookResponseDto create(CreateBookRequestDto bookRequestDto);
    List<BookResponseDto> findBooks(Pageable pageable);
    BookResponseDto findById(Long id);
    BookResponseDto updateBook(Long id, CreateBookRequestDto bookRequestDto);
}
