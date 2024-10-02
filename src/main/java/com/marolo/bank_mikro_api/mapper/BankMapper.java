package com.marolo.bank_mikro_api.mapper;

import com.marolo.bank_mikro_api.dto.BankDto;
import com.marolo.bank_mikro_api.entity.Bank;

public class BankMapper {

    public static BankDto mapToBankDto(Bank bank) {
        return new BankDto(
                bank.getId(),
                bank.getBankName(),
                bank.getBankEmail(),
                bank.getBankCity()
        );
    }

    public static Bank mapToBank(BankDto bankDto) {
        return new Bank(
                bankDto.getId(),
                bankDto.getBankName(),
                bankDto.getBankEmail(),
                bankDto.getBankCity()
        );
    }
}
