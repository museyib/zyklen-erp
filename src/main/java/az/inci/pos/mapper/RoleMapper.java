package az.inci.pos.mapper;

import az.inci.pos.dto.BmsRoleDto;
import az.inci.pos.entity.auth.BmsRole;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapIgnoreNulls(BmsRoleDto roleDto, @MappingTarget BmsRole role);

    BmsRole map(BmsRoleDto roleDto);

    BmsRoleDto map(BmsRole role);
}
