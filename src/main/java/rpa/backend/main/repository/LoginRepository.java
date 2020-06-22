package rpa.backend.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rpa.backend.main.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
