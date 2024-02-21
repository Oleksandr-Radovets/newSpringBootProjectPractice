package org.example.newspringboootprojectpractice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.newspringboootprojectpractice.dto.book.BookResponseDto;
import org.example.newspringboootprojectpractice.dto.book.CreateBookRequestDto;
import org.example.newspringboootprojectpractice.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService bookService;

    @Operation(summary = "create book", description = "create book")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    BookResponseDto createBook(@RequestBody CreateBookRequestDto bookRequestDto) {
        return bookService.create(bookRequestDto);
    }

    @Operation(summary = "find book by id", description = "find book by id")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/findById/{id}")
    public BookResponseDto findBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody CreateBookRequestDto bookRequestDto) {
        return bookService.updateBook(id, bookRequestDto);
    }

    @Operation(summary = "get all books", description = "get all books")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public List<BookResponseDto> findBooks(Pageable pageable) {
        return bookService.findBooks(pageable);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/findByCategoryId")
    public List<BookResponseDto> findAllByCategory(@PathVariable Long id) {
        return bookService.findAllByCategoryId(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
