package rpa.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpa.backend.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
