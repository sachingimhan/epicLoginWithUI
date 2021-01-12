package lk.epic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_")
public class User {
    @Id
    @Column(name = "uuid")
    private int uuid;
    @Column(name = "username")
    private String userName;
    @Column(name = "userpass")
    private String userPass;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "useraddress")
    private String userAddress;
    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "roleId", nullable = false)
    private UserRole userRole;
    @OneToMany(mappedBy = "user")
    private List<LoginHistory> histories;

    public User() {
    }

    public User(int uuid, String userName, String userPass, String fullName, String userAddress, UserRole userRole) {
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<LoginHistory> getHistories() {
        return histories;
    }

    public void setHistories(List<LoginHistory> histories) {
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
