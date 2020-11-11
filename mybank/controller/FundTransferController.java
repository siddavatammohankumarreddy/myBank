package com.mybank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.dto.FundTransferDto;
import com.mybank.dto.TransationResponseDto;
import com.mybank.entity.FundTransfer;
import com.mybank.service.FundTransferService;

@RestController
@RequestMapping("/user")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;
	

	
	@PostMapping(value = "/fundtransfer")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TransationResponseDto> fundTransfer(@RequestBody FundTransferDto fundTransferDto){
		//fundTransferService.fundTransfer(fundTransferDto);
		return new ResponseEntity<TransationResponseDto>(fundTransferService.fundTransfer(fundTransferDto),HttpStatus.CREATED);
  }
	
	@GetMapping(value = "/transactionStatement")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<FundTransfer>> getTransactions(@RequestParam("accountNumber")Long accountNumber,@RequestParam(defaultValue="0") Integer pageNo,@RequestParam(defaultValue="10") Integer pageSize, @RequestParam(defaultValue="transactionId") String sortByDesc){
		List<FundTransfer>list=fundTransferService.getTransactions(accountNumber,pageNo,pageSize,sortByDesc);
		
		return new ResponseEntity<List<FundTransfer>>(list,new HttpHeaders(),HttpStatus.OK);
	}
}
