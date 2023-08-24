package com.example.cms.cart.domain;


import com.example.cms.member.domain.Member;
import com.example.cms.cartitem.domain.CartItem;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Integer count;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    private LocalDateTime createdAt;

    public Cart(Member member, Integer count, LocalDateTime localDateTime) {
        this.member = member;
        this.count = count;
        this.createdAt = localDateTime;
    }

    public static Cart createCart(Member member){
        return new Cart(member,0,LocalDateTime.now());
    }

    public void addCart(Integer count){
        this.count += count;
    }
}