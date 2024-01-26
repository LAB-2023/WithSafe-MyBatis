package com.withsafe.domain.helmet.application;

import com.withsafe.domain.department.dao.DepartmentMapper;
import com.withsafe.domain.department.domain.Department;
import com.withsafe.domain.helmet.dao.HelmetMapper;
import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.user.dao.UserMapper;
import com.withsafe.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.withsafe.domain.helmet.dto.HelmetDTO.*;

@Service
@RequiredArgsConstructor
public class HelmetService {

    private final DepartmentMapper departmentMapper;
    private final HelmetMapper helmetMapper;

    /**
     * 저장
     * @param request
     * @param departmentName
     * @return
     */
    @Transactional
    public Long saveHelmetDTO(SaveRequest request, String departmentName) {
        Department department =
                departmentMapper.findByName(departmentName).orElseThrow(() -> new RuntimeException("해당 부서가 없습니다."));
        Helmet savedHelmet = request.toEntity(department);
        helmetMapper.save(savedHelmet);
        return savedHelmet.getId();
    }
}
