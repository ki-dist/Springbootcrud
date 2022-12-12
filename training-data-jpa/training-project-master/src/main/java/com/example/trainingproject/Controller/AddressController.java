package com.example.trainingproject.Controller;

import com.example.trainingproject.Service.AccountService;
import com.example.trainingproject.Service.AddressService;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/address")
@RestController
public class AddressController {
    AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }
    @PostMapping("/addAddress")

    public ResponseEntity<?> Save(@RequestBody Address address){
        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);

    }
    @GetMapping("/address")


    public ResponseEntity<List<Address>> findAllAddress(){
        List<Address> addressList =addressService.getAdress();

        return new ResponseEntity<>(addressList, HttpStatus.OK);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getById(id),HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id,@RequestBody Address address){
        addressService. updateAddress(address);
        return new ResponseEntity<>(addressService.getById(address.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
