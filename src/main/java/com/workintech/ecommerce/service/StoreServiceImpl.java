package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.StoreResponse;
import com.workintech.ecommerce.entity.Store;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.StoreRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    @Override
    public List<StoreResponse> findAll() {
        return DtoConverter.storeResponseListConverter(storeRepository.findAll());
    }

    @Override
    public Store findById(Long id) {
        Optional<Store> optionalStore=storeRepository.findById(id);
        if(optionalStore.isPresent()){
            return optionalStore.get();
        }
        throw new EcommerceException("Store is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public StoreResponse save(Store store) {
        return DtoConverter.storeResponseConverter(storeRepository.save(store));
    }

    @Override
    public StoreResponse update(Long id, Store store) {
        Store storeToUpdate=findById(id);
        storeToUpdate.setName(store.getName());
        storeToUpdate.setPhone(store.getPhone());
        storeToUpdate.setTaxNumber(store.getTaxNumber());
        return DtoConverter.storeResponseConverter(storeRepository.save(storeToUpdate));
    }

    @Override
    public StoreResponse delete(Long id) {
        Store storeToDelete=findById(id);
        if(storeToDelete!=null){
            storeRepository.delete(storeToDelete);
            return DtoConverter.storeResponseConverter(storeToDelete);
        }
        throw new EcommerceException("Store is not found with id: "+id, HttpStatus.NOT_FOUND);
    }
}
