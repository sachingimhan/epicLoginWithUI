package lk.epic.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "login_history")
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hid")
    private int hid;
    @Column(name = "date_stamp")
    private LocalDate date_stamp;
    @Column(name = "time_stamp")
    private LocalTime time_stamp;
    @ManyToOne
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", nullable = false)
    private User user;

    public LoginHistory() {
    }

    public LoginHistory(int hid, LocalDate date_stamp, LocalTime time_stamp, User user) {
        this.hid = hid;
        this.date_stamp = date_stamp;
        this.time_stamp = time_stamp;
        this.user = user;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public LocalDate getDate_stamp() {
        return date_stamp;
    }

    public void setDate_stamp(LocalDate date_stamp) {
        this.date_stamp = date_stamp;
    }

    public LocalTime getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(LocalTime time_stamp) {
        this.time_stamp = time_stamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
