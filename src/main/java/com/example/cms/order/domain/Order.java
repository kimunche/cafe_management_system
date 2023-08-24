package com.example.cms.order.domain;

import com.example.cms.member.domain.Member;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Column(name = "orders_number", nullable = false)
    private String ordersNumber;

    @Column(name = "orders_date", nullable = false)
    private LocalDateTime ordersDate;

    @Column(name = "cancel_date")
    private LocalDateTime cancelDate;

    @Column(name = "orders_price", nullable = false)
    private Integer ordersPrice;

    @Column(name = "payment", nullable = false)
    private Payments payment;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    @Builder
    public Order(Long id, String ordersNumber, LocalDateTime ordersDate, LocalDateTime cancelDate, Integer ordersPrice, Payments payment) {
        this.id = id;
        this.ordersNumber = ordersNumber;
        this.ordersDate = ordersDate;
        this.cancelDate = cancelDate;
        this.ordersPrice = ordersPrice;
        this.payment = payment;
    }

    public void cancel(LocalDateTime cancelDate){
        this.cancelDate = cancelDate;
    }
}
