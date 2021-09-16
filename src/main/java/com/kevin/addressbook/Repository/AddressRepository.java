package com.kevin.addressbook.Repository;

import com.kevin.addressbook.Model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findById(int id);
}
