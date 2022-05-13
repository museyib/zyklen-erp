package az.inci.pos.service.impl;

import az.inci.pos.dto.BmsRoleDto;
import az.inci.pos.entity.auth.BmsRole;
import az.inci.pos.mapper.BmsMapper;
import az.inci.pos.repository.RoleRepository;
import az.inci.pos.service.RoleService;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService
{
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final BmsMapper bmsMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository,
                           ModelMapper modelMapper)
    {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.bmsMapper = Mappers.getMapper(BmsMapper.class);
    }

    @Override
    public List<BmsRoleDto> getAll()
    {
        List<BmsRole> roles = roleRepository.findAll();
        return roles.stream()
                    .map(bmsRole -> modelMapper.map(bmsRole, BmsRoleDto.class))
                    .collect(Collectors.toList());
    }

    @Override
    public BmsRoleDto getById(String id)
    {
        return modelMapper.map(roleRepository.getById(id), BmsRoleDto.class);
    }

    @Override
    public BmsRoleDto saveRole(BmsRoleDto roleDto)
    {
        BmsRole bmsRole = modelMapper.map(roleDto, BmsRole.class);
        BmsRole savedRole = roleRepository.save(bmsRole);
        return modelMapper.map(savedRole, BmsRoleDto.class);
    }

    @Override
    public BmsRoleDto updateRole(String id, BmsRoleDto roleDto)
    {
        BmsRole role = roleRepository.getById(id);
        bmsMapper.mapToRoleIgnoreNulls(roleDto, role);
        BmsRole savedRole = roleRepository.save(role);
        return modelMapper.map(savedRole, BmsRoleDto.class);
    }

    @Override
    public void deleteRole(String id)
    {
        roleRepository.delete(roleRepository.getById(id));
    }
}
