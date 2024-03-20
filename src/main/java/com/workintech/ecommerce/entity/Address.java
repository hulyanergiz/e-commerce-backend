package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_address",schema = "ecommerce",
            joinColumns = @JoinColumn(name="address_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users=new HashSet<>();

    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    private List<Order> orders=new ArrayList<>();
}
