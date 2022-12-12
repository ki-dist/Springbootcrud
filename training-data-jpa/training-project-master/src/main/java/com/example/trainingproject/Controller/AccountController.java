package com.example.trainingproject.Controller;

import com.example.trainingproject.Dto.AccountDto;
import com.example.trainingproject.Service.AccountService;
import com.example.trainingproject.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/account")
@RestController
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService){
      this.accountService=accountService;
    }
    @PostMapping("/addAccount")

    public ResponseEntity<?> Save(@RequestBody Account account){
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.CREATED);

    }
    @GetMapping("/accounts")


    public ResponseEntity<List<Account>> findAllAccount(){
        List<Account> accountList =accountService.getAccounts();

        return new ResponseEntity<>(accountList, HttpStatus.OK);

    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getById(id),HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id,@RequestBody Account account){
        accountService. updateAccount(account);
        return new ResponseEntity<>(accountService.getById(account.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Account> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/accountByid")
    public ResponseEntity<List<AccountDto>> findByCustomerId(){
        List<AccountDto> accountList =accountService.getAccountByCustomerId();

        return new ResponseEntity<>(accountList, HttpStatus.OK);

    }
}

