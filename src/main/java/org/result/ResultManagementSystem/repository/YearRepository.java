package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.MyYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<MyYear,Long> {

}
