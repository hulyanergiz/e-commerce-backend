package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="address",schema="ecommerce")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="address_title")
    private String addressTitle;

    private String name;

    private String surname;

    private String phone;

    private String city;

    private String district;

    private String neighborhood;

    @Column(name = "address_details")
    private String addressDetails;


}
