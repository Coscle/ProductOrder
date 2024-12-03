package com.sparta.msa.exam.order.orders;


import com.sparta.msa.exam.order.client.ProductClient;
import com.sparta.msa.exam.order.client.ProductResponseDto;
import com.sparta.msa.exam.order.core.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = Order.createOrder(requestDto.getProductIds());
        Order savedOrder = orderRepository.save(order);
        return new OrderResponseDto(savedOrder.getId(), savedOrder.getProductIds());
    }

    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return new OrderResponseDto(order.getId(), order.getProductIds());
    }

    public OrderResponseDto addProductToOrder(Long orderId, ProductRequestDto requestDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));


        // 전체 상품 리스트 가져오기
        List<ProductResponseDto> products = productClient.getProducts();

        // 요청된 product_id가 존재하는지 확인
        Long productId = requestDto.getProduct_id();
        boolean productExists = products.stream()
                .anyMatch(product -> product.getId().equals(productId));

        if (!productExists) {
            throw new IllegalArgumentException("Product not found");
        }

        List<Long> productIds = order.getProductIds();
        productIds.add(requestDto.getProduct_id());

        Order updatedOrder = orderRepository.save(order);
        return new OrderResponseDto(updatedOrder.getId(), updatedOrder.getProductIds());
    }

}
