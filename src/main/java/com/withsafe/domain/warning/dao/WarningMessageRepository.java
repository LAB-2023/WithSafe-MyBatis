package com.withsafe.domain.warning.dao;

import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface WarningMessageRepository extends JpaRepository<WarningMessage, Long> {
    Optional<WarningMessage> findWarningMessageByTypeAndDepartmentName(WarningMessageType type, String departmentName);

//    @Query("select wm from WarningMessage wm join wm.department d where d.name = :departmentName")
    List<WarningMessage> findWarningMessageByDepartmentName(@Param("paramValue") String departmentName);
}
