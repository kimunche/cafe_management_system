package com.example.cms.order.controller.response;

import com.example.cms.member.domain.Member;
import com.example.cms.order.domain.Payments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class OrderDetailResponse {
    private String ordersNumber;
    private LocalDateTime ordersDate;
    private Integer ordersPrice;
    private Payments payment;
    private Member member;

    @Builder
    public OrderDetailResponse(String ordersNumber, LocalDateTime ordersDate, Integer ordersPrice, Payments payment, Member member) {
        this.ordersNumber = ordersNumber;
        this.ordersDate = ordersDate;
        this.ordersPrice = ordersPrice;
        this.payment = payment;
        this.member = member;
    }
}
