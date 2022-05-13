package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class BranchDto implements Serializable
{
    private final String id;
    private final String name;
    private final String shortName;
    private final String address1;
    private final String address2;
    private final String zip;
    private final String phone1;
    private final String phone2;
    private final String phone3;
    private final String phone4;
    private final String fax1;
    private final String fax2;
    private final String email;
    private final String web;
    private final String createdBy;
    private final Date createdAt;
    private final String modifiedBy;
    private final Date modifiedAt;
    private final boolean inactiveFlag;
}
