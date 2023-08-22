package com.example.cms.orderitems.controller.request;



import com.example.cms.item.domain.ItemStatus;

import com.example.cms.member.domain.Member;
import com.example.cms.member.domain.MemberStatus;
import com.example.cms.orderitems.domain.OrderItems;
import lombok.Data;

import java.time.LocalDate;


@Data
public class OrderItemsCreateRequest {


    private String name;
    private Integer count;
    private ItemStatus status;
//    private Member member;

}
