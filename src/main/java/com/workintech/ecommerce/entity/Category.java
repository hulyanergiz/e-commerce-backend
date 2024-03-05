package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Title cannot be null or blank.")
    @Size(min=2,max=100,message = "Title must have between 2 and 100 characters.")
    private String title;

    @NotBlank(message = "Img cannot be null or blank.")
    @Size(min=2,max=255,message = "Img must have between 2 and 100 characters.")
    private String img;

    @Min(value=0, message = "Rating cannot be null or less than zero.")
    @Max(value=5,message="Rating can be at most 5.0")
    private Double rating;

    @NotBlank(message ="Gender cannot be null or blank." )
    @Size(min=1,max=10,message = "Gender must have between 1 and 10 charachters.")
    private String gender;

    @NotBlank(message = "Code cannot be null or blank.")
    @Size(min=1,max=45, message = "Code must have between 1 and 45 characters.")
    private String code;
    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL)
    private List<Product> products;

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
