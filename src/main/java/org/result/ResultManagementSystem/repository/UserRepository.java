package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByUsernameOrEmail(String username,String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
