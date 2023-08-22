package com.example.cms.order.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @Column(name = "orders_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orders_number")
    private String ordersNumber;

    @Column(name = "orders_date")
    private LocalDateTime ordersDate;

    @Column(name = "cancel_date")
    private LocalDateTime cancelDate;

    @Column(name = "orders_price")
    private Integer ordersPrice;

    @Column(name = "payment")
    private Payments payment;
}
