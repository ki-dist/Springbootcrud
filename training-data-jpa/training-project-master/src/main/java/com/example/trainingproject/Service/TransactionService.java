package com.example.trainingproject.Service;

import com.example.trainingproject.Repository.AccountRepository;
import com.example.trainingproject.Repository.TransactionRepository;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {
    TransactionRepository transactionRepo;
    public TransactionService(TransactionRepository transactionRepo){
        this.transactionRepo =transactionRepo;
    }
    public Transaction saveTransaction(Transaction transaction){
       /* Optional<Transaction> existingTransaction =transactionRepo.findByAccountNumber(account.getAccountNumber());
        if(existingAccount.isPresent()){
            throw new RuntimeException("Accountt Exists add new Account");
        }*/
        return transactionRepo.save(transaction);
    }
    public List<Transaction> getTransaction(){
        List<Transaction> transactions = transactionRepo.findAll();
        if(transactions.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return transactions;
    }


    public Transaction getById(long id){
        return transactionRepo.findById(id).orElse(null);
    }
    public String deleteTransaction(long id){
        transactionRepo.deleteById(id);
        return "transaction deleted ||" +id;
    }
    public Transaction updateTransaction(Transaction transaction){
        Transaction existingTransaction=transactionRepo.findById(transaction.getId()).orElse(null);
        existingTransaction.setId(transaction.getId());
        existingTransaction.setAmount(transaction.getAmount());



        return transactionRepo.save(existingTransaction);
    }

}
