package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.RoleResponse;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public List<RoleResponse> findAll() {
        return DtoConverter.roleResponseListConverter(roleRepository.findAll());
    }

    @Override
    public RoleResponse save(Role role) {
        return DtoConverter.roleResponseConverter(roleRepository.save(role));
    }

}
