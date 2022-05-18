package az.inci.pos.mapper;

import az.inci.pos.dto.UserRoleDto;
import az.inci.pos.entity.auth.BmsRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper
{
    BmsRole map(UserRoleDto userRoleDto);
}
