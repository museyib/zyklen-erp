package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto implements Serializable
{
    private String id;
    private String name;
    private Integer accountTypeId;
}
