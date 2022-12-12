package com.example.trainingproject.Controller;

import com.example.trainingproject.Service.TransactionService;

import com.example.trainingproject.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {
    TransactionService transactionServ;
    public TransactionController(TransactionService transactionServ){
        this.transactionServ=transactionServ;
    }
    @PostMapping("/addTransaction")

    public ResponseEntity<?> Save(@RequestBody Transaction transaction){
        return new ResponseEntity<>(transactionServ.saveTransaction(transaction), HttpStatus.CREATED);

    }
    @GetMapping("/transactions")


    public ResponseEntity<List<Transaction>> findAllTransaction(){
        List<Transaction> accountList =transactionServ.getTransaction();

        return new ResponseEntity<>(accountList, HttpStatus.OK);

    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id){
        return new ResponseEntity<>(transactionServ.getById(id),HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long id,@RequestBody Transaction transaction){
        transactionServ. updateTransaction(transaction);
        return new ResponseEntity<>(transactionServ.getById(transaction.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Transaction> deleteTransaction(@PathVariable("id") Long id){
        transactionServ.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
