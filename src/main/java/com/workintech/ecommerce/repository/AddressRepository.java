package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("SELECT a FROM Address a LEFT JOIN FETCH a.users u WHERE u.id=:userId")
    List<Address> findAddressesByUserId(Long userId);
}
