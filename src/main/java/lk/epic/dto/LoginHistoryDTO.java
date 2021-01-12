package lk.epic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoginHistoryDTO {

    private int hid;
    private LocalDate date_stamp;
    private LocalTime time_stamp;
    @JsonIgnore
    private UserDTO user;

    public LoginHistoryDTO() {
    }

    public LoginHistoryDTO(LocalDate date_stamp, LocalTime time_stamp, UserDTO user) {
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
    public String getDate() {
        return date_stamp.toString();
    }

    public void setDate_stamp(LocalDate date_stamp) {
        this.date_stamp = date_stamp;
    }

    public LocalTime getTime_stamp() {
        return time_stamp;
    }
    public String getTime() {
        return time_stamp.toString();
    }

    public void setTime_stamp(LocalTime time_stamp) {
        this.time_stamp = time_stamp;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
