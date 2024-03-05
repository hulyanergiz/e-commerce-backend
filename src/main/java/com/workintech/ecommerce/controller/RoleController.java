package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.RoleResponse;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.service.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleResponse> findAll(){
        return roleService.findAll();
    }

    @PostMapping
    public RoleResponse save(@Valid @RequestBody Role role){
        return roleService.save(role);
    }

}
