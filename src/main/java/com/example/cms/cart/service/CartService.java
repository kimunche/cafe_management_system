package com.example.cms.cart.service;


import com.example.cms.cart.domain.Cart;
import com.example.cms.cart.repository.CartRepository;
import com.example.cms.cartitem.controller.request.CartItemCreateRequest;
import com.example.cms.cartitem.domain.CartItem;
import com.example.cms.cartitem.repository.CartItemRepository;
import com.example.cms.item.domain.Item;
import com.example.cms.item.repository.ItemRepository;
import com.example.cms.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
public class CartService {

    private final CartRepository cartRepository;
    public final ItemRepository itemRepository;
    public final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, ItemRepository itemRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    /**
     * 메뉴를 선택한 후에 메뉴들(리스트로 들어옴)이 카드에 담긴다.
     */
    @Transactional
    public void addCart(Member member, CartItemCreateRequest request){

        //카트 생성 멤버
        Cart cart = Cart.createCart(member);

        Cart saveCart = cartRepository.save(cart);

        List<CartItemCreateRequest> cartItemCreateRequests = request.getCartItemCreateRequests();
        for (CartItemCreateRequest cartItemCreateRequest : cartItemCreateRequests) {
            System.out.println("cartItemCreateRequest = " + cartItemCreateRequest);
        }
        for (CartItemCreateRequest cartItemCreateRequest : cartItemCreateRequests) {
            //카트에 총 상품의 수를 증가
            saveCart.addCart(cartItemCreateRequest.getCount());
            //request 들어온 상품을 찾고 cartItem 에 등록
            Item findItem = itemRepository.findByNameAndHotIce(cartItemCreateRequest.getName(), cartItemCreateRequest.getStatus());
            CartItem cartItem = CartItem.createCartItem(saveCart, findItem, findItem.getCost(), cartItemCreateRequest.getCount());
            cartItemRepository.save(cartItem);
        }
        Cart save = cartRepository.save(saveCart);

    }
}
