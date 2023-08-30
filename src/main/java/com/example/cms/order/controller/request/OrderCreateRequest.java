package com.example.cms.order.controller.request;

import com.example.cms.cart.controller.response.CartResponse;
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

    private Long cartId;
    private Integer ordersPrice;
    private Payments payment;
    private Long memberId;
    private CartResponse response;

    public OrderCreateRequest(Long cartId, Integer ordersPrice, Payments payment, Long memberId, CartResponse response) {
        this.cartId = cartId;
        this.ordersPrice = ordersPrice;
        this.payment = payment;
        this.memberId = memberId;
        this.response = response;
    }

    @Builder


    public Order toOrder(Member member){
        return Order.builder()
                .member(member)
                .payment(payment)
                .ordersPrice(response.getTotalPrice())
                .build();
    }
}
