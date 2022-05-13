package az.inci.pos.mapper;

import az.inci.pos.dto.BmsRoleDto;
import az.inci.pos.dto.BmsUserDto;
import az.inci.pos.entity.auth.BmsRole;
import az.inci.pos.entity.auth.BmsUser;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BmsMapper
{
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapToUserIgnoreNulls(BmsUserDto userDto, @MappingTarget BmsUser user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapToRoleIgnoreNulls(BmsRoleDto roleDto, @MappingTarget BmsRole role);
}
