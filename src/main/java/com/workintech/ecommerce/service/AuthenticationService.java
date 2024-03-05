package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserResponse register(String name, String email, String password, Long roleId){
        String encodedPassword=passwordEncoder.encode(password);
        Optional<Role> roleOptional=roleRepository.findById(roleId);
        Role role=new Role();
        if(roleOptional.isPresent()){
            role=roleRepository.findByCode(roleOptional.get().getCode()).orElseThrow();
        }
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        return DtoConverter.userResponseConverter(userRepository.save(user));


    }

}
