package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,String> {
}
