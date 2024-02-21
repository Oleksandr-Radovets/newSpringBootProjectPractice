package org.example.newspringboootprojectpractice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.newspringboootprojectpractice.dto.book.BookResponseDto;
import org.example.newspringboootprojectpractice.dto.book.CreateBookRequestDto;
import org.example.newspringboootprojectpractice.mapper.BookMapper;
import org.example.newspringboootprojectpractice.model.Book;
import org.example.newspringboootprojectpractice.repository.BookRepository;
import org.example.newspringboootprojectpractice.service.BookService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookResponseDto create(CreateBookRequestDto bookRequestDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookRequestDto)));
    }

    public List<BookResponseDto> findBooks(Pageable pageable) {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    public BookResponseDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("Can't book by id " + id)));
    }

    public BookResponseDto updateBook(Long id, CreateBookRequestDto bookRequestDto) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("Can't book by id " + id));
        Book entity = bookMapper.toEntity(bookRequestDto);
        entity.setId(book.getId());
        return bookMapper.toDto(bookRepository.save(entity));
    }

    @Override
    public List<BookResponseDto> findAllByCategoryId(Long categoryId) {
        return bookRepository.findAllByCategoryId(categoryId)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
