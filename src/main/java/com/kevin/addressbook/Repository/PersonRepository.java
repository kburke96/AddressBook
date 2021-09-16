package com.kevin.addressbook.Repository;

import com.kevin.addressbook.Model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    Person findById(int id);
}
