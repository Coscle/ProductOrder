package com.sparta.msa.exam.order.orders;

import com.sparta.msa.exam.order.core.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
