package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleUserDto implements Serializable
{
    private String userId;
    private String userName;
}
