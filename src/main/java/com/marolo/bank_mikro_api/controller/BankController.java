package com.marolo.bank_mikro_api.controller;

import com.marolo.bank_mikro_api.dto.BankDto;
import com.marolo.bank_mikro_api.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/banks")
public class BankController {

    private BankService bankService;

    // Add Bank REST API
    @PostMapping
    public ResponseEntity<BankDto> createBank(@RequestBody BankDto bankDto) {
        BankDto savedBank = bankService.createBank(bankDto);
        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
    }

    // Get Bank REST API
    @GetMapping("{id}")
    public ResponseEntity<BankDto> getBankById(@PathVariable("id") Long bankId) {
        BankDto bankDto = bankService.getBankById(bankId);
        return ResponseEntity.ok(bankDto);
    }

    // Get All Bank REST API
    @GetMapping
    public ResponseEntity<List<BankDto>> getAllBanks() {
        List<BankDto> banks = bankService.getAllBanks();
        return ResponseEntity.ok(banks);
    }

    // Update Bank REST API
    @PutMapping("{id}")
    public ResponseEntity<BankDto> updateBank(@PathVariable("id") Long bankId,
                                              @RequestBody BankDto updatedBank) {
        BankDto bankDto = bankService.updateBank(bankId, updatedBank);
        return ResponseEntity.ok(bankDto);
    }

    // Delete Bank REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBank(@PathVariable("id") Long bankId) {
        bankService.deleteBank(bankId);
        return ResponseEntity.ok("Bank deleted successfully");
    }
}
