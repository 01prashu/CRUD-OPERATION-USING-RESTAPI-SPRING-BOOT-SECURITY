package com.example.Register_Login.service;

import com.example.Register_Login.model.Address;
import com.example.Register_Login.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person createPerson(Person person);
    Person findPersonById(int id);
    Person updatePerson(int id,Person personDetails);
    List<Address> getAddressByPersonId(int id);
    void removePersonById(int id);
}
