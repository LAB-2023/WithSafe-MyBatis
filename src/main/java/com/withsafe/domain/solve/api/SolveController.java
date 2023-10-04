package com.withsafe.domain.solve.api;

import com.withsafe.domain.notice.application.NoticeService;
import com.withsafe.domain.notice.domain.NoticeType;
import com.withsafe.domain.notice.dto.NoticeDto;
import com.withsafe.domain.solve.application.SolveService;
import com.withsafe.domain.solve.dto.SolveDto;
import com.withsafe.domain.user.domain.User;
import com.withsafe.domain.warning.dao.WarningMessageRepository;
import com.withsafe.domain.warning.domain.WarningMessage;
import com.withsafe.domain.warning.domain.WarningMessageType;
import com.withsafe.domain.watch.dao.WatchRepository;
import com.withsafe.domain.watch.domain.Watch;
import com.withsafe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SolveController {

    private final SolveService solveService;
    @PostMapping("/solve-api/insert")
    public SolveDto.SaveRequest createSolve(@RequestBody SolveDto.SaveRequest saveRequest){
        solveService.saveSolve(saveRequest);
        return saveRequest;
    }
}
