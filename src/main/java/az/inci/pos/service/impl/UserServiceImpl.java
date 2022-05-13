package az.inci.pos.service.impl;

import az.inci.pos.dto.BmsUserDto;
import az.inci.pos.entity.auth.BmsRole;
import az.inci.pos.entity.auth.BmsUser;
import az.inci.pos.exception.ResourceNotFoundException;
import az.inci.pos.mapper.BmsMapper;
import az.inci.pos.repository.UserRepository;
import az.inci.pos.service.UserService;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BmsMapper bmsMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bmsMapper = Mappers.getMapper(BmsMapper.class);
    }

    @Override
    public List<BmsUserDto> getAll()
    {
        List<BmsUser> users = userRepository.findAll();
        return users.stream()
                    .map(user -> modelMapper.map(user, BmsUserDto.class))
                    .collect(Collectors.toList());
    }

    @Override
    public BmsUserDto getById(String id)
    {
        return modelMapper.map(userRepository.getById(id), BmsUserDto.class);
    }

    @Override
    public BmsUserDto createUser(BmsUserDto userDto)
    {
        BmsUser user = modelMapper.map(userDto, BmsUser.class);
        BmsUser savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, BmsUserDto.class);
    }

    @Override
    public BmsUserDto updateUser(String id, BmsUserDto userDto)
    {
        BmsUser user = userRepository.getById(id);
        bmsMapper.mapToUserIgnoreNulls(userDto, user);
        Set<BmsRole> roles = userDto.getRoles()
                                    .stream()
                                    .map(userRoleDto -> modelMapper
                                            .map(userRoleDto, BmsRole.class))
                                    .collect(Collectors.toSet());
        user.setBmsRoles(roles);
        BmsUser savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, BmsUserDto.class);
    }

    @Override
    public void deleteUser(String id)
    {
        BmsUser user = userRepository.findById(id)
                                     .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        userRepository.delete(user);
    }
}
