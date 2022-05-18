package az.inci.pos.controller;

import az.inci.pos.dto.BmsUserDto;
import az.inci.pos.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userRepository)
    {
        this.userService = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<BmsUserDto>> getAllUser()
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(userService.getAll());
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
