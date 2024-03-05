package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.StoreResponse;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.service.StoreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

    private StoreService storeService;

    @GetMapping
    public List<StoreResponse> findAll(){
        return storeService.findAll();
    }

    @PostMapping
    public StoreResponse save(@Valid @RequestBody Store store){
        return storeService.save(store);
    }
    @PutMapping("/{id}")
    public StoreResponse update(@PathVariable Long id,@Valid @RequestBody Store store){
        return storeService.update(id,store);
    }

    @DeleteMapping("/{id}")
    public StoreResponse delete(@PathVariable Long id){
        return storeService.delete(id);
    }
}
