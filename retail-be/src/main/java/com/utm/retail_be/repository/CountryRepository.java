package com.utm.retail_be.repository;

import com.utm.retail_be.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Short> {
  Optional<Country> findByName(String name);
}