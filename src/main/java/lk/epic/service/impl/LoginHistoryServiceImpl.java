package lk.epic.service.impl;

import lk.epic.dto.LoginHistoryDTO;
import lk.epic.entity.LoginHistory;
import lk.epic.repo.LoginHistoryRepo;
import lk.epic.service.LoginHistoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepo historyRepo;
    private final ModelMapper mapper;

    public LoginHistoryServiceImpl(LoginHistoryRepo historyRepo, ModelMapper mapper) {
        this.historyRepo = historyRepo;
        this.mapper = mapper;
    }

    @Override
    public boolean logHistory(LoginHistoryDTO dto) {
        historyRepo.save(mapper.map(dto, LoginHistory.class));
        return historyRepo.existsById(dto.getUser().getUuid());
    }

    @Override
    public List<LoginHistoryDTO> getLoginHistory(int i) {
        List<LoginHistory> userHistory = historyRepo.selectAllHistory(i);
        return mapper.map(userHistory, new TypeToken<List<LoginHistoryDTO>>() {
        }.getType());
    }

}
