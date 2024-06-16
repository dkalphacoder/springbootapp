package com.dragonb0rn.springbootapp.chronicles.repositories;

import com.dragonb0rn.springbootapp.chronicles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
