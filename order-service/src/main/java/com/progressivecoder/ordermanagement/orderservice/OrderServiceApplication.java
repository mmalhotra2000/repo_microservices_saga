package com.progressivecoder.ordermanagement.orderservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.progressivecoder.ordermanagement.orderservice.dto.commands.OrderCreateDTO;
import com.progressivecoder.ordermanagement.orderservice.repositories.OrderCreateRepository;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {
	@Autowired
	private OrderCreateRepository orderCreateRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		OrderCreateDTO orderCreateDTO1 = new OrderCreateDTO("Soap", new BigDecimal(23.33), "INR");
		OrderCreateDTO orderCreateDTO2 = new OrderCreateDTO("Brush", new BigDecimal(235.33), "INR");
		OrderCreateDTO orderCreateDTO3 = new OrderCreateDTO("Paste", new BigDecimal(900), "INR");

		orderCreateRepository.save(orderCreateDTO1);
		orderCreateRepository.save(orderCreateDTO2);
		orderCreateRepository.save(orderCreateDTO3);

	}

}
