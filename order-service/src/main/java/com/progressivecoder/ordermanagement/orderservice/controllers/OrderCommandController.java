package com.progressivecoder.ordermanagement.orderservice.controllers;

import com.progressivecoder.ordermanagement.orderservice.dto.commands.OrderCreateDTO;
import com.progressivecoder.ordermanagement.orderservice.repositories.OrderCreateRepository;
import com.progressivecoder.ordermanagement.orderservice.services.commands.OrderCommandService;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orders")
@Api(value = "Order Commands", description = "Order Commands Related Endpoints", tags = "Order Commands")
public class OrderCommandController {

	@Autowired
	private OrderCreateRepository orderCreateRepository;

	private OrderCommandService orderCommandService;

	public OrderCommandController(OrderCommandService orderCommandService) {
		this.orderCommandService = orderCommandService;
	}

	@PostMapping("/create")
	public CompletableFuture<String> createOrder(@RequestBody OrderCreateDTO orderCreateDTO) {
		return orderCommandService.createOrder(orderCreateDTO);
	}

	@GetMapping("/all")
	public List<OrderCreateDTO> getALLOrders() {
		return orderCreateRepository.findAll();
	}
}
