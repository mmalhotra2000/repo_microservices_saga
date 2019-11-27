package com.progressivecoder.ordermanagement.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progressivecoder.ordermanagement.orderservice.security.model.AuthenticationResponse;

@Repository
public interface AuthenticationResponseRepository extends JpaRepository<AuthenticationResponse, Long> {

	AuthenticationResponse findByUserName(String username);

}
