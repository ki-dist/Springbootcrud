package com.example.trainingproject.Service;

import com.example.trainingproject.Repository.AccountRepository;
import com.example.trainingproject.Repository.CustomerRepository;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    CustomerRepository customerRepo;
    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo =customerRepo;
    }
    public Customer saveCustomer(Customer customer){
        Optional<Customer> existingCustomer =customerRepo.findByFullName(customer.getFullName());
        if(existingCustomer.isPresent()){
            throw new RuntimeException("Customer Exists add new Customer");
        }
        return customerRepo.save(customer);
    }
    public List<Customer> getCustomers(){
        List<Customer> customers = customerRepo.findAll();
        if(customers.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return customers;
    }


    public Customer getById(long id){
        return customerRepo.findById(id).orElse(null);
    }
    public String deleteCustomer(long id){
        customerRepo.deleteById(id);
        return "Customer deleted ||" +id;
    }
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer =customerRepo.findById(customer.getId()).orElse(null);
       /* existingCustomer.setId(customer.getId());
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAge(customer.getAge());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setPhone(customer.getPhone());
*/
        return customerRepo.save(existingCustomer);
    }

}
