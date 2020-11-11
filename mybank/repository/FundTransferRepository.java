package com.mybank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybank.entity.FundTransfer;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

	Page<FundTransfer> findByAccountNumber(Long accountNumber, Pageable paging);

}
