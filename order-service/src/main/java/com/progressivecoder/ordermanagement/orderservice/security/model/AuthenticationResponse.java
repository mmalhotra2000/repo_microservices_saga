package com.progressivecoder.ordermanagement.orderservice.security.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AuthenticationResponse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long seq;

	@JsonIgnore
	private String userName;

	private  String jwt;
	
	

	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public AuthenticationResponse(String userName, String jwt) {
		super();
		this.userName = userName;
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}