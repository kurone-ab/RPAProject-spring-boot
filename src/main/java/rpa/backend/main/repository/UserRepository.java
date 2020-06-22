package rpa.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpa.backend.main.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
