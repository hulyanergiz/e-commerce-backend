package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="category",schema="ecommerce")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String img;

    private Double rating;

    private String gender;

    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL)
    private List<Product> products;

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
