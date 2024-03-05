package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="product",schema="ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name cannot be null or blank.")
    @Size(min=2,max=100, message="Name must have between 2 and 100 characters.")
    private String name;

    @NotBlank(message="Description cannot be null or blank.")
    @Size(min=2,max=255, message="Description must have between 2 and 255 characters.")
    private String description;

    @Min(value=0, message = "Price cannot be null or less than zero.")
    private Double price;

    @Min(value=0, message = "Stock cannot be null or less than zero.")
    private Long stock;

    @Min(value=0, message = "Rating cannot be null or less than zero.")
    @Max(value=5,message="Rating can be at most 5.0")
    private Double rating;

    @Column(name="sell_count")
    private Long sellCount;

    private String[] images;

    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="store_id")
    private Store store;


}
