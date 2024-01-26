package com.withsafe.domain.warning.dao;

import com.withsafe.domain.warning.domain.WarningMessageJpa;
import com.withsafe.domain.warning.domain.WarningMessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarningMessageRepository extends JpaRepository<WarningMessageJpa, Long> {
    Optional<WarningMessageJpa> findWarningMessageByTypeAndDepartmentJpaName(WarningMessageType type, String departmentName);

//    @Query("select wm from WarningMessage wm join wm.department d where d.name = :departmentName")
    List<WarningMessageJpa> findWarningMessageByDepartmentJpaName(@Param("paramValue") String departmentName);
}
