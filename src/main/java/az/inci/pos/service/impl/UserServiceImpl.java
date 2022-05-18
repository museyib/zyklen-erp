package az.inci.pos.service.impl;

import az.inci.pos.dto.BmsUserDto;
import az.inci.pos.entity.auth.BmsRole;
import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.exception.ResourceNotFoundException;
import az.inci.pos.mapper.UserMapper;
import az.inci.pos.mapper.UserRoleMapper;
import az.inci.pos.repository.UserRepository;
import az.inci.pos.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.userRoleMapper = Mappers.getMapper(UserRoleMapper.class);
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    @Override
    public List<BmsUserDto> getAll()
    {
        List<BmsUser> users = userRepository.findAll();
        return users.stream()
                    .map(userMapper::map)
                    .collect(Collectors.toList());
    }

    @Override
    public BmsUserDto getById(String id)
    {
        return userMapper.map(userRepository.getById(id));
    }

    @Override
    public BmsUserDto createUser(BmsUserDto userDto)
    {
        BmsUser user = userMapper.map(userDto);
        BmsUser savedUser = userRepository.save(user);
        return userMapper.map(savedUser);
    }

    @Override
    public BmsUserDto updateUser(String id, BmsUserDto userDto)
    {
        BmsUser user = userRepository.getById(id);
        userMapper.mapIgnoreNulls(userDto, user);
        Set<BmsRole> roles = userDto.getRoles()
                                    .stream()
                                    .map(userRoleMapper::map)
                                    .collect(Collectors.toSet());
        user.setBmsRoles(roles);
        BmsUser savedUser = userRepository.save(user);
        return userMapper.map(savedUser);
    }

    @Override
    public void deleteUser(String id)
    {
        BmsUser user = userRepository.findById(id)
                                     .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        userRepository.delete(user);
    }
}
