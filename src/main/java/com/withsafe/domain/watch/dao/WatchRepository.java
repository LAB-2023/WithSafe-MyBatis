package com.withsafe.domain.watch.dao;

import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.domain.watch.dto.StartRequestDto;
import com.withsafe.domain.watch.dto.WatchDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {

    @Query("select w, u.name from Watch w left join w.user u join w.department d where d.name = :departmentName")
    List<Object[]> findByDepartmentName(@Param("departmentName") String departmentName);

    Optional<Object> findByUserAndDepartment(User user, Department department);

    Optional<Object> findBySerialNum(String serialNum);

    @Query("select new com.withsafe.domain.watch.dto.StartRequestDto(w.id, u.id, u.name, d.name) " +
            "from Watch w left join w.user u left join w.department d " +
            "where w.serialNum = :serialNum")
    Optional<StartRequestDto> findDtoBySerialNum(@Param("serialNum") String serialNum);
}
