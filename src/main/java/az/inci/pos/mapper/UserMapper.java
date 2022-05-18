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
public interface UserMapper
{
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapIgnoreNulls(BmsUserDto userDto, @MappingTarget BmsUser user);

    BmsUser map(BmsUserDto userDto);

    BmsUserDto map(BmsUser user);
}
