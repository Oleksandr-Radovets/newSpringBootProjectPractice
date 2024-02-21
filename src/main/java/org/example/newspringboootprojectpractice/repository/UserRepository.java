package org.example.newspringboootprojectpractice.repository;

import org.example.newspringboootprojectpractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

  User save(User user);

  @Query("FROM User u WHERE u.email =:email")
  Optional<User> findByEmail(@Param("email") String email);
}
