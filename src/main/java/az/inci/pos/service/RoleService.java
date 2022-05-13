package az.inci.pos.service;

import az.inci.pos.dto.BmsRoleDto;

import java.util.List;

public interface RoleService
{
    List<BmsRoleDto> getAll();
    BmsRoleDto getById(String id);
    BmsRoleDto saveRole(BmsRoleDto roleDto);
    BmsRoleDto updateRole(String id, BmsRoleDto roleDto);
    void deleteRole(String id);
}
