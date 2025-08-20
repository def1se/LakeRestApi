package ru.ashitok.lake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ashitok.lake.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsById(int id);
    Boolean existsByEmail(String email);
    User findByEmail(String email);
}
