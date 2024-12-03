package com.sparta.msa.exam.product.products;

import com.sparta.msa.exam.product.core.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

