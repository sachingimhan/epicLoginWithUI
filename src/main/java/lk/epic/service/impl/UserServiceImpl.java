package lk.epic.service.impl;

import lk.epic.dto.LoginHistoryDTO;
import lk.epic.dto.UserDTO;
import lk.epic.entity.User;
import lk.epic.repo.UserRepo;
import lk.epic.service.LoginHistoryService;
import lk.epic.service.UserService;
import lk.epic.util.Encrypt;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    /*
     * success : 1
     * unSuccess : 0
     * miss match : 2
     * already exists : 3
     * not found : 4
     * Error : 5
     * */
    private final ModelMapper mapper;
    private final UserRepo userRepo;
    private final LoginHistoryService loginHistoryService;

    public UserServiceImpl(ModelMapper mapper, UserRepo userRepo, LoginHistoryService loginHistoryService) {
        this.mapper = mapper;
        this.userRepo = userRepo;
        this.loginHistoryService = loginHistoryService;
    }

    @Override
    public int addUser(UserDTO dto) {
        if (userRepo.checkUserName(dto.getUserName()) > 0) {
            return 3;
        } else {
            dto.setUserPass(Encrypt.encrypt(dto.getUserPass()));
            userRepo.save(mapper.map(dto, User.class));
            return 1;
        }
    }

    @Override
    public int updateUser(UserDTO dto) {
        Optional<User> user = userRepo.findByUserName(dto.getUserName());
        if (user.isPresent()) {
            dto.setUserPass(Encrypt.encrypt(dto.getUserPass()));
            dto.setUuid(user.get().getUuid());
            userRepo.save(mapper.map(dto, User.class));
            return 1;
        } else {
            return 4;
        }
    }

    @Override
    public int deleteUser(String userName) {
        Optional<User> user = userRepo.findByUserName(userName);
        if (user.isPresent()) {
            userRepo.deleteByUserName(userName);
            return 1;
        } else {
            return 4;
        }
    }

    @Override
    public UserDTO loginCheck(String userName, String password) {
        Optional<User> user = userRepo.findByUserNameAndUserPass(userName, Encrypt.encrypt(password));
        if (user.isPresent()) {
            User foundUser = user.get();
            //user login history
            loginHistoryService.logHistory(new LoginHistoryDTO(
                    LocalDate.now(),
                    LocalTime.now(),
                    mapper.map(user.get(), UserDTO.class)

            ));
            return new UserDTO(
                    foundUser.getUuid(),
                    foundUser.getUserName(),
                    foundUser.getFullName()
            );
        } else {
            return null;
        }

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<UserDTO>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public List<LoginHistoryDTO> getUserLoginHistory(String userName) {
        Optional<User> user = userRepo.findByUserName(userName);
        if (user.isPresent()) {
            return loginHistoryService.getLoginHistory(user.get().getUuid());
        }
        return null;
    }
}
