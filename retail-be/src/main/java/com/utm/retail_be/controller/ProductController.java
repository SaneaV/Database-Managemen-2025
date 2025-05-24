package com.utm.retail_be.controller;

import com.utm.retail_be.dto.ProductDto;
import com.utm.retail_be.dto.ProductKpiDto;
import com.utm.retail_be.entity.Product;
import com.utm.retail_be.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        List<ProductDto> dtoList = new ArrayList<>();

        productList.forEach(product -> {
            ProductDto dto = ProductDto.builder()
                    .productId(product.getProductID())
                    .productName(product.getProductName())
                    .productCategory(product.getProductCategory().getName())
                    .build();

            dtoList.add(dto);
        });

        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/kpi/{productId}")
    public ResponseEntity<ProductKpiDto> getProduct(@PathVariable("productId") Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        ProductKpiDto kpiDto = new ProductKpiDto();

        if (product.isPresent()) {

            // TODO: calculate KPI

            kpiDto.setProductId(product.get().getProductID());
        } else {
            throw new IllegalArgumentException("Product not found");
        }

        return ResponseEntity.ok(kpiDto);
    }

}
