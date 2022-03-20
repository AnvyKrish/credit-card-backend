package com.publicis.creditcard.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "The database generated creditCard ID")
	private Integer creditCardID;
	@ApiModelProperty(notes = "Name on the card")
	private String name;
	@ApiModelProperty(notes = "Card Number")
	private String cardNumber;
	@ApiModelProperty(notes = "Balance in the card, default is 0 ")
	private String balance = "0";
	@ApiModelProperty(notes = "Card limit")
	private String limit;

}
