package com.example.cms.order.controller.request;

import com.example.cms.member.domain.Member;
import com.example.cms.order.domain.Order;
import com.example.cms.order.domain.Payments;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderCreateRequest {

    private String ordersNumber;
    private LocalDateTime ordersDate;
    private Integer ordersPrice;
    private Payments payment;
    private Member member;

    @Builder
    public OrderCreateRequest(String ordersNumber, LocalDateTime ordersDate, Integer ordersPrice, Payments payment, Member member) {
        this.ordersNumber = ordersNumber;
        this.ordersDate = ordersDate;
        this.ordersPrice = ordersPrice;
        this.payment = payment;
        this.member = member;
    }

    public Order toOrder(){
        return Order.builder()
                .ordersNumber(ordersNumber)
                .ordersDate(ordersDate)
                .ordersPrice(ordersPrice)
                .payment(payment)
                .build();
    }
}
