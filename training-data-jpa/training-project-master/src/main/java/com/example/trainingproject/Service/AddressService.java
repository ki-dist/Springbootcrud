package com.example.trainingproject.Service;
import com.example.trainingproject.Repository.AddressRepository;

import com.example.trainingproject.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    AddressRepository addressRepo;
    public AddressService(AddressRepository addressRepo){
        this.addressRepo =addressRepo;
    }
    public Address saveAddress(Address address){
        return addressRepo.save(address);
    }
    public List<Address> getAdress(){
        List<Address> addresses = addressRepo.findAll();
        if(addresses.isEmpty()){
            throw new RuntimeException("There are no account registered!");
        }

        return addresses;
    }


    public Address getById(long id){
        return addressRepo.findById(id).orElse(null);
    }
    public String deleteAddress(long id){
        addressRepo.deleteById(id);
        return "Address deleted ||" +id;
    }
    public Address updateAddress(Address address){
        Address existingAddress =addressRepo.findById(address.getId()).orElse(null);
        existingAddress.setId(address.getId());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setCity(address.getCity());
        existingAddress.setZipcode(address.getZipcode());

        return addressRepo.save(existingAddress);
    }
}
