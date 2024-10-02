package com.marolo.bank_mikro_api.service;

import com.marolo.bank_mikro_api.dto.BankDto;

import java.util.List;

public interface BankService {
    BankDto createBank(BankDto bankDto);

    BankDto getBankById(Long bankId);

    List<BankDto> getAllBanks();

    BankDto updateBank(Long bankId, BankDto updatedBank);

    void deleteBank(Long bankId);
}
