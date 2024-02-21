package org.example.newspringboootprojectpractice.dto.book;

import lombok.Getter;
import lombok.Setter;
import org.example.newspringboootprojectpractice.model.Category;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class CreateBookRequestDto {
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String coverImage;
    private boolean isDeleted;
    private Set<Category> categorySet;
}
