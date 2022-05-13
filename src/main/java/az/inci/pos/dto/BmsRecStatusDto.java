package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BmsRecStatusDto implements Serializable
{
    private Integer id;
    private String name;
    private boolean inactiveFlag;
}
