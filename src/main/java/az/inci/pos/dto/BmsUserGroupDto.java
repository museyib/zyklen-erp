package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BmsUserGroupDto implements Serializable
{
    private String id;
    private String name;
}
