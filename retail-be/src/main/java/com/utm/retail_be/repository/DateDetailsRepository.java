package com.utm.retail_be.repository;

import com.utm.retail_be.entity.DateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateDetailsRepository extends JpaRepository<DateDetails, Integer> {}