package com.progressivecoder.ordermanagement.orderservice.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progressivecoder.ordermanagement.orderservice.dto.commands.OrderCreateDTO;

@Repository
public interface OrderCreateRepository extends JpaRepository<OrderCreateDTO, BigDecimal> {

}
