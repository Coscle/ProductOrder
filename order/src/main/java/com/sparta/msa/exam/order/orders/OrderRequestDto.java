package com.sparta.msa.exam.order.orders;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private List<Long> productIds;
}
