package lk.epic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(value = {"uuid", "userPass", "histories"}, allowSetters = true)
public class UserDTO {

    private int uuid;
    private String userName;
    private String userPass;
    private String fullName;
    private String userAddress;
    private UserRoleDTO userRole;
    private List<LoginHistoryDTO> histories;

    public UserDTO() {
    }

    public UserDTO(int uuid, String userName, String fullName) {
        this.uuid = uuid;
        this.userName = userName;
        this.fullName = fullName;
    }

    public UserDTO(int uuid, String userName, String userPass, String fullName, String userAddress, UserRoleDTO userRole) {
        this.uuid = uuid;
        this.userName = userName;
        this.userPass = userPass;
        this.fullName = fullName;
        this.userAddress = userAddress;
        this.userRole = userRole;
    }


    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public List<LoginHistoryDTO> getHistories() {
        return histories;
    }

    public void setHistories(List<LoginHistoryDTO> histories) {
        this.histories = histories;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
