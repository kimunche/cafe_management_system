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

    private Payments payment;
    private CartResponse cartResponse;

    @Builder
    public OrderCreateRequest(Payments payment, CartResponse cartResponse) {
        this.payment = payment;
        this.cartResponse = cartResponse;
    }

    public Order toOrder(Member member){
        return Order.builder()
                .member(member)
                .payment(payment)
                .ordersPrice(cartResponse.getTotalPrice())
                .build();
    }
}
