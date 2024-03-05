package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.RoleResponse;
import com.workintech.ecommerce.entity.Role;

import java.util.List;

public interface RoleService {

    List<RoleResponse> findAll();
    RoleResponse save(Role role);



}
