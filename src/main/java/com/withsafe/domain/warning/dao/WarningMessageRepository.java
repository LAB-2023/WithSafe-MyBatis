package com.withsafe.domain.warning.dao;

import com.withsafe.domain.warning.domain.WarningMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningMessageRepository extends JpaRepository<WarningMessage, Long> {

}
