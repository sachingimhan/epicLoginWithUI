package lk.epic.service;

import lk.epic.dto.LoginHistoryDTO;
import lk.epic.dto.UserDTO;

import java.util.List;

public interface UserService {

    int addUser(UserDTO dto);

    int updateUser(UserDTO dto);

    int deleteUser(String userName);

    UserDTO loginCheck(String userName, String password);

    List<UserDTO> getAllUsers();

    List<LoginHistoryDTO> getUserLoginHistory(String userName);

}
