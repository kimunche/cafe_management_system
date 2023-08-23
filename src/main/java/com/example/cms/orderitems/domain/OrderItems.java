package com.example.cms.orderitems.domain;

import com.example.cms.item.domain.Item;
import com.example.cms.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity @Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItems {

    @Id
    @Column(name = "order_items_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq")
    private Item item;

    private Integer count;

    private Integer price;

    @Builder
    public OrderItems(Item item, Integer count, Integer price) {
        this.item = item;
        this.count = count;
        this.price = price;
    }

    public static OrderItems createOrderItems(Item item, Integer price, Integer count, Member member){
        OrderItems orderItems = new OrderItems();
        orderItems.setItem(item);
        orderItems.setPrice(price);
        orderItems.setPrice(count);
        orderItems.setMember(member);
        return orderItems;
    }
//    취소 처리?
//    public void cancel(){
//    }
    public Integer getTotalPrice(){
        return  getPrice() * getCount();
    }
}
