package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Order",schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private String orderDate;

    private Double price;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;

    @ManyToMany
    @JoinTable(name="cart_item_order",schema = "ecommerce",
            joinColumns =@JoinColumn(name="cart_item_id"),
            inverseJoinColumns =@JoinColumn(name = "order_id"))
    private List<CartItem> cartItems;

}
