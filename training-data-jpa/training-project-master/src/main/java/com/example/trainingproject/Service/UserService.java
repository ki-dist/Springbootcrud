package com.example.trainingproject.Service;

import com.example.trainingproject.Repository.AccountRepository;
import com.example.trainingproject.Repository.UserRepository;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    UserRepository userRepo;
    public UserService(UserRepository userRepo){
        this.userRepo =userRepo;
    }
    public User saveUser(User user){
        /*Optional<User> existingAccount =userRepo.findByAccountNumber(account.getAccountNumber());
        if(existingAccount.isPresent()){
            throw new RuntimeException("Accountt Exists add new Account");
        }*/
        return userRepo.save(user);
    }
    public List<User> getUsers(){
        List<User> users = userRepo.findAll();
        if(users.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return users;
    }


    public User getById(long id){
        return userRepo.findById(id).orElse(null);
    }
    public String deleteUser(long id){
        userRepo.deleteById(id);
        return "User deleted ||" +id;
    }
    public User updateUser(User user){
        User existingUser =userRepo.findById(user.getId()).orElse(null);
        existingUser.setId(user.getId());
        existingUser.setUsername(user.getUsername());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());

        return userRepo.save(existingUser);
    }

}
