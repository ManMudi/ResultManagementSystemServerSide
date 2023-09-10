package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
