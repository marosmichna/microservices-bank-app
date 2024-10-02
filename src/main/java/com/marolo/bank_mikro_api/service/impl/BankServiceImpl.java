package com.marolo.bank_mikro_api.service.impl;

import com.marolo.bank_mikro_api.dto.BankDto;
import com.marolo.bank_mikro_api.entity.Bank;
import com.marolo.bank_mikro_api.exception.ResourceNotFoundException;
import com.marolo.bank_mikro_api.mapper.BankMapper;
import com.marolo.bank_mikro_api.repository.BankRepository;
import com.marolo.bank_mikro_api.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;
    @Override
    public BankDto createBank(BankDto bankDto) {

        Bank bank = BankMapper.mapToBank(bankDto);
        Bank savedBank = bankRepository.save(bank);
        return BankMapper.mapToBankDto(savedBank);
    }

    @Override
    public BankDto getBankById(Long bankId) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank is not exists with this id : " + bankId));
        return BankMapper.mapToBankDto(bank);
    }

    @Override
    public List<BankDto> getAllBanks() {
        List<Bank> banks = bankRepository.findAll();
        return banks.stream().map(BankMapper::mapToBankDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto updateBank(Long bankId, BankDto updatedBank) {

        Bank bank = bankRepository.findById(bankId).orElseThrow(
                () -> new ResourceNotFoundException("Bank is not exists with this id: " + bankId)
        );

        bank.setBankName(updatedBank.getBankName());
        bank.setBankCity(updatedBank.getBankCity());
        bank.setBankEmail(updatedBank.getBankEmail());

        Bank updatedBankObj = bankRepository.save(bank);

        return BankMapper.mapToBankDto(updatedBankObj);
    }

    @Override
    public void deleteBank(Long bankId) {

        Bank bank = bankRepository.findById(bankId).orElseThrow(
                () -> new ResourceNotFoundException("Bank is not exists with this id: " + bankId)
        );

        bankRepository.deleteById(bankId);

    }
}
