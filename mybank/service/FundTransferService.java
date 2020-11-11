package com.mybank.service;

import java.util.List;

import com.mybank.dto.FundTransferDto;
import com.mybank.dto.TransationResponseDto;
import com.mybank.entity.FundTransfer;

public interface FundTransferService {

	public TransationResponseDto fundTransfer(FundTransferDto fundTransferDto);

	public List<FundTransfer> getTransactions(Long accountNumber, Integer pageNo, Integer pageSize, String sortByDesc);

}
