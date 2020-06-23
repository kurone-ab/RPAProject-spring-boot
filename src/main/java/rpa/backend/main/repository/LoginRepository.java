package rpa.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpa.backend.main.entity.Login;
import rpa.backend.main.entity.User;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUser(User user);
}
