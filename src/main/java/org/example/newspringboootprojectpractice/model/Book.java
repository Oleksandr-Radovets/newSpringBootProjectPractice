package org.example.newspringboootprojectpractice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@SQLDelete(sql = "UPDATE books SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted = false")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;
    private String coverImage;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categorySet ;
}