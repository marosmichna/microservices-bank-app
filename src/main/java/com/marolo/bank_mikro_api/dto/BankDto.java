package com.marolo.bank_mikro_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private Long id;
    private String bankName;
    private String bankCity;
    private String bankEmail;
}
