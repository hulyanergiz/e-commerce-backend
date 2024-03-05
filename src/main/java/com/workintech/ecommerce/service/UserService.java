package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserResponse;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.EcommerceException;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.util.DtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->{
            throw new UsernameNotFoundException("User credentials are not valid");
        });
    }
    public User findById(Long id){
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new EcommerceException("User is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    public UserResponse delete(Long id){
        User userToDelete=findById(id);
       if(userToDelete!=null){
           userRepository.delete(userToDelete);
           return DtoConverter.userResponseConverter(userToDelete);
       }
       throw new EcommerceException("User is not found with id: "+id, HttpStatus.NOT_FOUND);
    }
}
