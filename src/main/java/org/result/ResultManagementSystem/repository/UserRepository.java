package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
