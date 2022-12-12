package com.example.trainingproject.Repository;

import com.example.trainingproject.Dto.AccountDto;
import com.example.trainingproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
   // @Query(Select Acc)
    Optional<Account> findByAccountNumber(String accountNumber);
  //  @Query("SELECT new com.example.trainingproject.Dto.AccountDto  ")
  @Query("delete from Account ac where ac.id=?1")
  void deleteAccount(Long id);
  @Query("SELECT new com.example.trainingproject.Dto.AccountDto(a.accountType, a.accountNumber,c.fullName)"
          + "FROM Account a JOIN a.customer c ")

  List<AccountDto> findAccountByCustomerId();
}
//Account a LEFT JOIN a.customer c
//on a.customer.id = c.id