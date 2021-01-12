package lk.epic.repo;

import lk.epic.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Integer> {
    @Query(value = "SELECT * FROM login_history WHERE uuid=:uid", nativeQuery = true)
    List<LoginHistory> selectAllHistory(int uid);
}
