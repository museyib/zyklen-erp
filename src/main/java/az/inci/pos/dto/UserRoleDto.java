package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleDto implements Serializable
{
    private String roleId;
    private String roleName;
}
