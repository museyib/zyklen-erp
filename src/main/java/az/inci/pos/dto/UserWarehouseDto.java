package az.inci.pos.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserWarehouseDto implements Serializable
{
    private String warehouseId;
    private String warehouseName;
}
