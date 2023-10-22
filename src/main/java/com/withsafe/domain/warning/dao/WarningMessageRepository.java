package com.withsafe.domain.warning.dao;

import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface WarningMessageRepository extends JpaRepository<WarningMessage, Long> {
    Optional<WarningMessage> findWarningMessageByType(WarningMessageType type);
}
