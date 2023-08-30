package com.example.cms.order.repository;

import com.example.cms.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order save(Order order);

    boolean existsByOrdersId(String orderId);

    Optional<String> findByOrdersId(String orderId);
}
