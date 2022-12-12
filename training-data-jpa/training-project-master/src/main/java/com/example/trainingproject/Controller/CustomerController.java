package com.example.trainingproject.Controller;

import com.example.trainingproject.Service.AccountService;
import com.example.trainingproject.Service.CustomerService;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/customer")
@RestController
public class CustomerController {
    CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    @PostMapping("/addCustomer")

    public ResponseEntity<?> Save(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);

    }
    @GetMapping("/customers")


    public ResponseEntity<List<Customer>> findAllCustomer(){
        List<Customer> accountList =customerService.getCustomers();

        return new ResponseEntity<>(accountList, HttpStatus.OK);

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
        customerService. updateCustomer(customer);
        return new ResponseEntity<>(customerService.getById(customer.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Account> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
