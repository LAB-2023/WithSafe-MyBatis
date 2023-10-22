package com.withsafe.domain.department.dto;

import com.withsafe.domain.department.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class DepartmentDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class saveDepartment {

        private String name;

        @Builder
        public Department toEntity() {
            return Department.builder()
                    .name(this.name)
                    .build();
        }
    }
}

