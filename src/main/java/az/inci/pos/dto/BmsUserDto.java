package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BmsUserDto implements Serializable
{
    private String id;
    private String userName;
    private String email;
    private Boolean adminFlag;
    private Boolean terminalFlag;
    private Boolean inactiveFlag;
    private Boolean retailFlag;
    private String bmsUserGroupId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
    private String emcData;
    private Set<UserRoleDto> roles;
    private Set<UserWarehouseDto> warehouses;
    private Set<UserCompanyDto> companies;
}
