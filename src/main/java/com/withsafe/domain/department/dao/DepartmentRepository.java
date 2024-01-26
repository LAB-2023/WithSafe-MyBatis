package com.withsafe.domain.department.dao;

import com.withsafe.domain.department.domain.DepartmentJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentJpa, Long> {

    boolean existsByName(String name);

    Optional<DepartmentJpa> findByName(String name);

    @Query("SELECT d FROM DepartmentJpa d WHERE d.name NOT IN :excludedDepartments")
    List<DepartmentJpa> findAllExceptDepartments(@Param("excludedDepartments") List<String> departmentNames);
}

