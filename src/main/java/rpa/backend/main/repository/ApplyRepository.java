package rpa.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpa.backend.main.entity.Apply;
import rpa.backend.main.entity.User;

import java.util.Optional;

//Apply Table에 접속하는 DAO
public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    Optional<Apply> findByUser(User user);
}
