package com.sparta.msa.exam.order.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private List<Long> productIds;
}
