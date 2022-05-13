package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyDto implements Serializable
{
    private String id;
    private String name;
    private String shortName;
    private String address1;
    private String address2;
}
