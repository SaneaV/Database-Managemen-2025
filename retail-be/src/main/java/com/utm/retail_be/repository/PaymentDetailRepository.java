package com.utm.retail_be.repository;

import com.utm.retail_be.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, UUID> {}