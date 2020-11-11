package com.mybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.entity.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long>{
	
	Optional<AccountDetails> findByAccountNumber(Long accountNumber);

}
