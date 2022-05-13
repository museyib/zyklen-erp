package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class BmsRoleDto implements Serializable
{
    private String id;
    private String name;
    private Set<RoleUserDto> users;
}
