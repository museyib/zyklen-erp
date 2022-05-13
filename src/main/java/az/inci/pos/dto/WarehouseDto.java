package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class WarehouseDto implements Serializable
{
    private final String id;
    private final String name;
    private final String shortName;
    private final String branchId;
    private final String branchZip;
    private final String branchPhone1;
    private final String branchPhone2;
    private final String branchPhone3;
    private final String branchPhone4;
    private final String branchFax1;
    private final String branchFax2;
    private final String branchEmail;
    private final String branchWeb;
    private final String branchCreatedBy;
    private final Date branchCreatedAt;
    private final String branchModifiedBy;
    private final Date branchModifiedAt;
    private final boolean branchInactiveFlag;
    private final boolean pickingFlag;
    private final boolean locationFlag;
    private final boolean forbiddenFlag;
    private final boolean inactiveFlag;
    private final String createdBy;
    private final Date createdAt;
    private final String modifiedBy;
    private final Date modifiedAt;
}
