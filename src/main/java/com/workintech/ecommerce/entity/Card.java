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
@Table(name="card",schema = "ecommerce")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="card_title")
    private String cardTitle;

    @Column(name="name_on_card")
    private String nameOnCard;

    @Column(name="card_no")
    private String cardNo;

    @Column(name="expire_month")
    private Integer expireMonth;

    @Column(name = "expire_year")
    private Integer expireYear;

    private Integer cvv;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_card",schema = "ecommerce",
            joinColumns = @JoinColumn(name="card_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    private Set<User> users=new HashSet<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Order> orders=new ArrayList<>();

}
