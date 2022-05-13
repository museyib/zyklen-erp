package az.inci.pos.service;

import az.inci.pos.dto.BmsUserDto;

import java.util.List;

public interface UserService
{
    List<BmsUserDto> getAll();
    BmsUserDto createUser(BmsUserDto user);
    BmsUserDto updateUser(String id, BmsUserDto user);
    void deleteUser(String id);
    BmsUserDto getById(String id);
}
