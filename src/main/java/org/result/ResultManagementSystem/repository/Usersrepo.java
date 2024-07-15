package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Usersrepo extends JpaRepository<OurUsers,Long> {
   Optional<OurUsers> findByEmail(String email);
}
