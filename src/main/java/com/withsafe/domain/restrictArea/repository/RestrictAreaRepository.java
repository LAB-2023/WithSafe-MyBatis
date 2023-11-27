package com.withsafe.domain.restrictArea.repository;

import com.withsafe.domain.restrictArea.domain.RestrictArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictAreaRepository extends JpaRepository<RestrictArea, Long> {
}
