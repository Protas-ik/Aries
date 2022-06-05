package com.example.aries.repos;

import com.example.aries.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    //List<Order> findFlightsByFlightStatus(OrderStatus orderStatus);
    Order findOrderById(Long id);
    List<Order> findOrderByOrderOwnerId(Long id);

}
