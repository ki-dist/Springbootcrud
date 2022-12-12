package com.example.trainingproject.Dto;

import com.example.trainingproject.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private AccountType accountType;
    private String accountNumber;
    private String fullName;

}
