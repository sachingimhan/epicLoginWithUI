package lk.epic.service;

import lk.epic.dto.LoginHistoryDTO;

import java.util.List;

public interface LoginHistoryService {
    boolean logHistory(LoginHistoryDTO dto);
    List<LoginHistoryDTO> getLoginHistory(int i);
}
