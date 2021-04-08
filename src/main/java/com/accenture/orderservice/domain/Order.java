package com.accenture.orderservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.LAZY)
    private Set<ProductOrder> productOrders;

    private Float totalPrice;

    private Date purchaseDate;

    private Long buyerId;

    public Order(Set<ProductOrder> productOrders, Float totalPrice, Date purchaseDate, Long buyerId) {
        this.productOrders = productOrders;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.buyerId = buyerId;
    }
}
