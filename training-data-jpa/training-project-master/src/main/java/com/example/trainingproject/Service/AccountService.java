package com.example.trainingproject.Service;

import com.example.trainingproject.Dto.AccountDto;
import com.example.trainingproject.Repository.AccountRepository;
import com.example.trainingproject.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    AccountRepository accountRepo;
    public AccountService(AccountRepository accountRepo){
        this.accountRepo =accountRepo;
    }
public Account saveAccount(Account account){
        Optional<Account> existingAccount =accountRepo.findByAccountNumber(account.getAccountNumber());
        if(existingAccount.isPresent()){
            throw new RuntimeException("Accountt Exists add new Account");
        }
    return accountRepo.save(account);
}
    public List<Account> getAccounts(){
        List<Account> accounts = accountRepo.findAll();
        if(accounts.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return accounts;
    }


    public Account getById(long id){
        return accountRepo.findById(id).orElse(null);
    }
    public String deleteAccount(long id){
        accountRepo.deleteById(id);
        return "Account deleted ||" +id;
    }
    public Account updateAccount(Account account){
        Account existingAccount =accountRepo.findById(account.getId()).orElse(null);
        /*existingAccount.setId(account.getId());
        existingAccount.setAccountType(account.getAccountType());
        //existingAccount.setAccountNumber(account.getAccountNumber());
*/
        return accountRepo.save(existingAccount);
    }
    public List<AccountDto> getAccountByCustomerId(){
        List<AccountDto> accounts = accountRepo.findAccountByCustomerId();
        if(accounts.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return accounts;
    }

}
