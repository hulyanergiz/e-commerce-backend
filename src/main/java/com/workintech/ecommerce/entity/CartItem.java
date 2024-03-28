package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cart_item",schema="ecommerce")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @Column(name="is_checked")
    private Boolean isChecked;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="cart_item_order",schema = "ecommerce",
            joinColumns =@JoinColumn(name="order_id"),
            inverseJoinColumns =@JoinColumn(name = "cart_item_id"))
    private Set<Order> orders=new HashSet<>();
}
