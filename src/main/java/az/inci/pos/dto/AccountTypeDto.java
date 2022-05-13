package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountTypeDto implements Serializable
{
    private final Integer id;
    private final String name;
    private final String masterTable;
    private final String trxTable;
    private final String formClass;
}
