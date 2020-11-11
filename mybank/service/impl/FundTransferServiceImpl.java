package com.mybank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mybank.dto.FundTransferDto;
import com.mybank.dto.TransationResponseDto;
import com.mybank.entity.AccountDetails;
import com.mybank.entity.FundTransfer;
import com.mybank.exception.AccountNotFoundException;
import com.mybank.repository.AccountDetailsRepository;
import com.mybank.repository.FundTransferRepository;
import com.mybank.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	FundTransferRepository fundTransferRepository;

	@Autowired
	AccountDetailsRepository accountRepository;

	@Override
	public TransationResponseDto fundTransfer(FundTransferDto fundTransferDto) {

		FundTransfer fundTransfer = new FundTransfer();
		//System.out.println(".......:" + fundTransferDto.getToAccountNumber());
		fundTransfer.setAccountNumber(fundTransferDto.getAccountNumber());
		fundTransfer.setToAccountNumber(fundTransferDto.getToAccountNumber());
		fundTransfer.setAmount(fundTransferDto.getAmount());
		fundTransfer.setDate(fundTransferDto.getDate());
		fundTransfer.setDescription(fundTransferDto.getDescription());
		fundTransfer.setTransactionId(fundTransferDto.getTransactionId());

		fundTransferRepository.save(fundTransfer);

		AccountDetails from = new AccountDetails();
		AccountDetails to = new AccountDetails();

		Optional<AccountDetails> fromAccount = accountRepository
				.findByAccountNumber(fundTransferDto.getAccountNumber());

		if (!fromAccount.isPresent()) {
			throw new AccountNotFoundException("From Account is not valid");
		}

		from = fromAccount.get();

		Optional<AccountDetails> toAccount = accountRepository
				.findByAccountNumber(fundTransferDto.getToAccountNumber());

		if (!toAccount.isPresent()) {
			throw new AccountNotFoundException("To Account is not valid");
		}

		to = toAccount.get();

		TransationResponseDto transationResponseDto = new TransationResponseDto();

		if (fundTransferDto.getAmount() > from.getCurrentBalance()) {

			transationResponseDto.setMessage("InsufficientFund please maintain sufficient fund");
			return transationResponseDto;
		}

		from.setCurrentBalance(from.getCurrentBalance() - fundTransferDto.getAmount());

		accountRepository.save(from);

		to.setCurrentBalance(to.getCurrentBalance() + fundTransferDto.getAmount());
		accountRepository.save(to);

		transationResponseDto.setMessage("sucesss");
		return transationResponseDto;
	}

	@Override
	public List<FundTransfer> getTransactions(Long accountNumber, Integer pageNo, Integer pageSize, String sortByDesc) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("transactionId").descending());
		Page<FundTransfer> pagesResult = fundTransferRepository.findByAccountNumber(accountNumber, paging);
		if (pagesResult.hasContent()) {
			return pagesResult.getContent();

		} else {
			return new ArrayList<FundTransfer>();

		}
	}

}
