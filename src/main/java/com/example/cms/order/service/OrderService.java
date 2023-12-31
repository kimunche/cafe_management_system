package com.example.cms.order.service;

import com.example.cms.cart.domain.Cart;
import com.example.cms.cart.repository.CartRepository;
import com.example.cms.member.domain.Member;
import com.example.cms.member.repository.MemberRepository;
import com.example.cms.order.controller.request.OrderCreateRequest;
import com.example.cms.order.controller.response.OrderCreateResponse;
import com.example.cms.order.controller.response.OrderDetailResponse;
import com.example.cms.order.domain.Order;
import com.example.cms.order.repository.OrderRepository;
import com.example.cms.utils.exception.CommonException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.undo.CannotUndoException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.example.cms.utils.exception.ErrorCode.DATA_NOT_FOUND;
import static com.example.cms.utils.exception.ErrorCode.DUPLICATE_RESOURCE;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private MemberRepository memberRepository;
    private CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, MemberRepository memberRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest request) {

        //1. 회원 멤버십 포인트 확인
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new CommonException(DATA_NOT_FOUND));

        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(()-> new CommonException(DATA_NOT_FOUND));

        Order order = request.toOrder(member, cart);

        //1-2. payment 확인

        //2. 포인트 차감
        int memberPoint = order.getMember().getMembershipPoint();
        int payAmount = order.getOrdersPrice();

        if (memberPoint < payAmount){
            throw new IllegalStateException("포인트가 부족합니다.");
        }else{
            int remainPoint = memberPoint - payAmount;
            //남은 포인트 set
            member.updatePoint(remainPoint);
        }

        //3. 오더 생성
        //랜덤 오더번호 생성
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedOrderId = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        //orderId 중복체크
        boolean isDuplicateOrderId = orderRepository.existsByOrdersId(generatedOrderId);

        if(isDuplicateOrderId){
            throw new CommonException(DUPLICATE_RESOURCE);
        }else{
            order.setOrdersId(generatedOrderId);
            orderRepository.save(order);
        }

        return OrderCreateResponse.of(order);
    }

    public List<OrderDetailResponse> findByOrdersId(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalStateException("주문 내역이 없습니다."));

        return List.of(order).stream()
                .map(OrderDetailResponse::of)
                .collect(Collectors.toList());
    }

    public void cancel(String orderId) {
        //1.포인트 업뎃
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalStateException("주문 내역이 없습니다."));

        int paidPoint = order.getOrdersPrice();

        Member member = memberRepository.findById(order.getCart().getMember().getId())
                .orElseThrow(()-> new CommonException(DATA_NOT_FOUND));

        //결제 포인트 + 잔여포인트
        int resultPoint = paidPoint + member.getMembershipPoint();

        member.updatePoint(resultPoint);

        //2. 오더 삭제
        orderRepository.deleteById(orderId);
    }
}
