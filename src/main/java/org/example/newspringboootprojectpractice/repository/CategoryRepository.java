package org.example.newspringboootprojectpractice.repository;

import org.example.newspringboootprojectpractice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
