package com.withsafe.domain.restrictArea.dao;

import com.withsafe.domain.restrictArea.domain.RestrictAreaJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrictAreaRepository extends JpaRepository<RestrictAreaJpa, Long> {

}
