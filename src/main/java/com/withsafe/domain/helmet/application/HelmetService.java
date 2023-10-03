package com.withsafe.domain.helmet.application;

import com.withsafe.domain.helmet.dao.HelmetRepository;
import com.withsafe.domain.helmet.domain.Helmet;
import com.withsafe.domain.helmet.dto.HelmetDTO.SaveRequest;
import com.withsafe.domain.user.domain.User;
import com.withsafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HelmetService {
    private final HelmetRepository helmetRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long saveHelmetDTO(SaveRequest request) {
        User user = userRepository.findById(request.getWatchId()).orElseThrow(RuntimeException::new);
        Helmet savedHelmet = helmetRepository.save(request.toEntity(user));
        return savedHelmet.getId();
    }
}
