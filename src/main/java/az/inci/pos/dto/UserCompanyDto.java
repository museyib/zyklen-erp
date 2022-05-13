package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCompanyDto implements Serializable
{
    private String companyId;
    private String companyName;
}
