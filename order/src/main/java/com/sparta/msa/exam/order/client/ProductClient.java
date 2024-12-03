package com.sparta.msa.exam.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductResponseDto> getProducts();

    @GetMapping("/products/{productId}")
    ProductResponseDto getProductById(@PathVariable Long productId);

}
