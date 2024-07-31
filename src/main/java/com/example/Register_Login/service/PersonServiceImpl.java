package com.example.Register_Login.service;

import com.example.Register_Login.model.Address;
import com.example.Register_Login.model.Person;
import com.example.Register_Login.repositories.PersonRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepositories personRepositories;

    @Transactional
    @Override
    public Person createPerson(Person person) {
        return personRepositories.save(person);
    }

    @Override
    public Person findPersonById(int id) {
        return personRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

    @Transactional
    @Override
    public Person updatePerson(int id, Person personDetails) {
        Person person = personRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));

        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setPassword(personDetails.getPassword());
        person.setEmail(personDetails.getEmail());
        person.getAddress().clear();
        for (Address address : personDetails.getAddress()) {
            address.setPerson(person);
            person.getAddress().add(address);
        }

        return personRepositories.save(person);
    }

    @Override
    public List<Address> getAddressByPersonId(int id) {
        Person person = personRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        return person.getAddress();
    }

    @Transactional
    @Override
    public void removePersonById(int id) {
        Person person = personRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        personRepositories.delete(person);
    }
}
