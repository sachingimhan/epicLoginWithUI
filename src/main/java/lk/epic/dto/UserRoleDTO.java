package lk.epic.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class UserRoleDTO {

    private int roleId;
    private String roleName;

    private List<UserDTO> users;

    public UserRoleDTO() {
    }

    public UserRoleDTO(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
