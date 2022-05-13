package az.inci.pos.controller;

import az.inci.pos.dto.BmsRoleDto;
import az.inci.pos.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController
{
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService)
    {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<BmsRoleDto>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(roleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BmsRoleDto> getById(@PathVariable String id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(roleService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<BmsRoleDto> createRole(@RequestBody BmsRoleDto roleDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(roleService.saveRole(roleDto));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BmsRoleDto> updateRole(@PathVariable String id,
                                                 @RequestBody BmsRoleDto roleDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(roleService.updateRole(id, roleDto));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteRole(@PathVariable String id)
    {
        roleService.deleteRole(id);

        return ResponseEntity.status(HttpStatus.OK)
                             .body("Role deleted successfully!");
    }
}
