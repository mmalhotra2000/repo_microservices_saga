package com.progressivecoder.ordermanagement.orderservice.services.commands;

import com.progressivecoder.ordermanagement.orderservice.aggregates.OrderStatus;
import com.progressivecoder.ecommerce.commands.CreateOrderCommand;
import com.progressivecoder.ordermanagement.orderservice.dto.commands.OrderCreateDTO;
import com.progressivecoder.ordermanagement.orderservice.repositories.AuthenticationResponseRepository;
import com.progressivecoder.ordermanagement.orderservice.security.model.AuthenticationResponse;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

	private final CommandGateway commandGateway;

	@Autowired
	private AuthenticationResponseRepository authenticationResponseRepository;

	public OrderCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@Override
	public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		AuthenticationResponse authenticationResponse = authenticationResponseRepository
				.findByUserName(userDetails.getUsername());

		return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), orderCreateDTO.getItemType(),
				orderCreateDTO.getPrice(), orderCreateDTO.getCurrency(), String.valueOf(OrderStatus.CREATED),authenticationResponse.getJwt()));
	}
}
