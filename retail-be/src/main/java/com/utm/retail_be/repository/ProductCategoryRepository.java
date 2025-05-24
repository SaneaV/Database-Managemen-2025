package com.utm.retail_be.repository;

import com.utm.retail_be.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Short> {
  Optional<ProductCategory> findByName(String name);
}