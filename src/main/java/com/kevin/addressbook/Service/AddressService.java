package com.kevin.addressbook.Service;

import java.util.List;

import com.kevin.addressbook.Model.Address;
import com.kevin.addressbook.Repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepo;

    public List<Address> getAll() {
        List<Address> allAddresses = addressRepo.findAll();

        return allAddresses;
    }

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public void deleteAddress(int id) {
        addressRepo.deleteById(id);
    }

    public void updateAddress(int id, String streetName, String city, String state, String postalCode) {
        Address addressToUpdate = addressRepo.findById(id);
        addressToUpdate.setStreet(streetName);
        addressToUpdate.setCity(city);
        addressToUpdate.setState(state);
        addressToUpdate.setPostalCode(postalCode);
        addressRepo.save(addressToUpdate);
    }
}
