package com.publicis.creditcard.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CREDITCARD_ID")
	private Integer creditCardID;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardNumber;
	
	@Column(name = "BALANCE")
	private String balance;
	
	@Column(name = "`LIMIT`")
	private String limit;
	

}
