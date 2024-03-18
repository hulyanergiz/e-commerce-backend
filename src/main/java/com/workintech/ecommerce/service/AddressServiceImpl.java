package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.AddressResponse;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.AddressRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{

    private  final AddressRepository addressRepository;

    private final  UserService userService;

    @Override
    public List<AddressResponse> findAllForUser(Long userId) {
        return DtoConverter.addressResponseListConverter(addressRepository.findAddressesByUserId(userId));
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> optionalAddress=addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            return optionalAddress.get();
        }
        throw new EcommerceException("Address is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse getById(Long id) {
        return DtoConverter.addressResponseConverter(findById(id));
    }

    @Override
    public AddressResponse save(Long userId, Address address) {
        User user=userService.findById(userId);
        if(user!=null){
            address.getUsers().add(user);
            return DtoConverter.addressResponseConverter(addressRepository.save(address));
        }
        throw new EcommerceException("User is not found with id: "+userId,HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse delete(Long userId, Long id) {
        User user=userService.findById(userId);
        Address addressToDelete=findById(id);
        if(addressToDelete.getUsers().contains(user)){
            addressToDelete.getUsers().remove(user);
            addressRepository.delete(addressToDelete);
            return DtoConverter.addressResponseConverter(addressToDelete);
        }
        throw new EcommerceException("Address with id "+id+" is not found in addresses of user with id: "+userId,HttpStatus.NOT_FOUND);
    }
}
