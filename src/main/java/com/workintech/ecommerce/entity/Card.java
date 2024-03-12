package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="card",schema = "ecommerce")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_on_card")
    private String nameOnCard;

    @Column(name="card_no")
    private String cardNo;

    @Column(name="expire_month")
    private Integer expireMonth;

    @Column(name = "expire_year")
    private Integer expireYear;

    private Integer cvv;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

}
