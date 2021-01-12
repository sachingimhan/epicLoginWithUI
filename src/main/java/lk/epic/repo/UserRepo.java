package lk.epic.repo;

import lk.epic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT COUNT(uuid) FROM user_ WHERE username=:s", nativeQuery = true)
    int checkUserName(String s);

    Optional<User> findByUserNameAndUserPass(String username, String userpass);

    void deleteByUserName(String username);

    Optional<User> findByUserName(String userName);
}
