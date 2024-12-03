package com.sparta.msa.exam.order.orders;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 주문 추가 API
    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto requestDto) {
        OrderResponseDto responseDto = orderService.createOrder(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 주문 추가 실패 처리 API
    @PostMapping("/fail")
    public ResponseEntity<String> createOrderFail() {
        return ResponseEntity.ok("잠시 후에 주문 추가를 요청 해주세요.");
    }

    // 주문 단건 조회 API
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long orderId) {
        OrderResponseDto responseDto = orderService.getOrder(orderId);
        return ResponseEntity.ok(responseDto);
    }

    // 주문에 상품 추가 API
    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> addProductToOrder(
            @PathVariable Long orderId,
            @RequestBody ProductRequestDto requestDto
    ) {
        OrderResponseDto responseDto = orderService.addProductToOrder(orderId, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}

