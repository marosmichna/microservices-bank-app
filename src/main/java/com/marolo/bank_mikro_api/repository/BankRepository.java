package com.marolo.bank_mikro_api.repository;

import com.marolo.bank_mikro_api.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
