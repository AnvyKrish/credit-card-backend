package com.publicis.creditcard.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicis.creditcard.Exceptions.InvalidCardException;
import com.publicis.creditcard.Exceptions.NotFoundException;
import com.publicis.creditcard.dto.CreditCardDTO;
import com.publicis.creditcard.service.CreditCardService;
import com.publicis.creditcard.utilities.ResponseDTO;
import com.publicis.creditcard.utilities.StatusEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin
@RestController
@RequestMapping("/api")
@Api(value="CreditCard", description="Credit card Processing Document")
@RequiredArgsConstructor
@Slf4j
public class CreditCardController {

	private final CreditCardService creditCardService;

	@ApiOperation(value = "Adding a new card", response = Iterable.class)
	@RequestMapping(value = "/v1/addCard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<CreditCardDTO>>> addCard(@RequestBody CreditCardDTO creditCardDTO)
			throws InvalidCardException {
		log.info("<<<<<<addCard CreditCardController >>>>>>");
		ResponseDTO<List<CreditCardDTO>> creditCardRespDTO = creditCardService.addCreditCard(creditCardDTO);
		if (creditCardRespDTO.getStatusMsg().equals(StatusEnum.SUCCESS.getStatus())) {
			return ResponseEntity.ok(creditCardRespDTO);
		} else {
			throw new InvalidCardException();
		}
	}

	@ApiOperation(value = "View a list of credit cards", response = Iterable.class)
	@RequestMapping(value = "/v1/getAllCards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<CreditCardDTO>>> getAllCards() throws NotFoundException {
		log.info("<<<<<<getAllCards CreditCardController >>>>>>");
		ResponseDTO<List<CreditCardDTO>> creditCardRespDTO = creditCardService.getAllCards();
		if (creditCardRespDTO.getData() != null && creditCardRespDTO.getData().size() > 0) {
			return ResponseEntity.ok(creditCardRespDTO);
		} else {
			throw new NotFoundException();
		}
	}
}
