package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.AddressResponse;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/user/{userId}")
    public List<AddressResponse> findAllForUser(@PathVariable Long userId){
        return addressService.findAllForUser(userId);
    }

    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping("/user/{userId}")
    public AddressResponse save(@PathVariable Long userId, @RequestBody Address address){
        return addressService.save(userId,address);
    }

    @DeleteMapping("/user/{userId}/{id}")
    public AddressResponse delete(@PathVariable Long userId,@PathVariable Long id){
        return addressService.delete(userId, id);
    }
}
