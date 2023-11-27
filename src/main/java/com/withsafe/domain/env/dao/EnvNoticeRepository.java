package com.withsafe.domain.env.dao;

import com.withsafe.domain.env.domain.EnvNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvNoticeRepository extends JpaRepository<EnvNotice, Long> {
}
