package az.inci.pos.service.impl;

import az.inci.pos.dto.BmsRoleDto;
import az.inci.pos.entity.auth.BmsRole;
import az.inci.pos.mapper.RoleMapper;
import az.inci.pos.repository.RoleRepository;
import az.inci.pos.service.RoleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService
{
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
        this.roleMapper = Mappers.getMapper(RoleMapper.class);
    }

    @Override
    public List<BmsRoleDto> getAll()
    {
        List<BmsRole> roles = roleRepository.findAll();
        return roles.stream()
                    .map(roleMapper::map)
                    .collect(Collectors.toList());
    }

    @Override
    public BmsRoleDto getById(String id)
    {
        return roleMapper.map(roleRepository.getById(id));
    }

    @Override
    public BmsRoleDto saveRole(BmsRoleDto roleDto)
    {
        BmsRole bmsRole = roleMapper.map(roleDto);
        BmsRole savedRole = roleRepository.save(bmsRole);
        return roleMapper.map(savedRole);
    }

    @Override
    public BmsRoleDto updateRole(String id, BmsRoleDto roleDto)
    {
        BmsRole role = roleRepository.getById(id);
        roleMapper.mapIgnoreNulls(roleDto, role);
        BmsRole savedRole = roleRepository.save(role);
        return roleMapper.map(savedRole);
    }

    @Override
    public void deleteRole(String id)
    {
        roleRepository.delete(roleRepository.getById(id));
    }
}
