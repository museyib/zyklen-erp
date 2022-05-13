package az.inci.pos.controller;

import az.inci.pos.dto.BmsUserDto;
import az.inci.pos.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    private final ModelMapper modelMapper;

    public UserController(UserService userRepository, ModelMapper modelMapper)
    {
        this.userService = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Iterable<BmsUserDto>> getAllUser()
    {
        List<BmsUserDto> userResponseList = userService.getAll()
                                              .stream()
                                              .map(user -> modelMapper
                                                      .map(user, BmsUserDto.class))
                                              .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK)
                             .body(userResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BmsUserDto> getById(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(userService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BmsUserDto> createUser(@RequestBody BmsUserDto userDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(userService.createUser(userDto));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BmsUserDto> updateUser(@PathVariable  String id,
                                                 @RequestBody BmsUserDto userDto)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK)
                             .body("User deleted successfully!");
    }
}
