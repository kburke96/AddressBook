package com.kevin.addressbook.Service;

import java.util.List;

import com.kevin.addressbook.Model.Address;
import com.kevin.addressbook.Model.Person;
import com.kevin.addressbook.Repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepo;

    public List<Person> getAll() {
        List<Person> allPersons = personRepo.findAll();

        return allPersons;
    }

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public void deletePerson(int id) {
        personRepo.deleteById(id);
    }

    public void updatePerson(int id, String firstName, String lastName) {
        Person personToUpdate = personRepo.findById(id);
        personToUpdate.setFirstName(firstName);
        personToUpdate.setLastName(lastName);
        personRepo.save(personToUpdate);
    }

    public void addAddressToPerson(int id, Address address) {
        Person personToUpdate = personRepo.findById(id);
        personToUpdate.setAddress(address);
        personRepo.save(personToUpdate);
    }

    public int countPersons() {
        List<Person> allPersons = personRepo.findAll();
        return allPersons.size();
    }
}
