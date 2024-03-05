package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
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
@Table(name="store",schema="ecommerce")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name cannot be null or blank.")
    @Size(min=2,max=45, message="Name must have between 2 and 45 characters.")
    private String name;

    @NotBlank(message = "Phone cannot be null or blank.")
    @Size(min=7,max=20, message = "Phone must have between 7 and 20 characters.")
    private String phone;

    @NotBlank(message = "TaxNumber cannot be null or blank.")
    @Size(min=3,max=45, message = "TaxNumber must have between 3 and 45 characters.")
    @Column(name="tax_number")
    private String taxNumber;

    @NotBlank(message = "Iban cannot be null or blank.")
    @Size(min=3,max=45,message ="Iban must have between 3 and 45 characters." )
    private String iban;

    @OneToMany(mappedBy="store",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Product> products;

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
}
