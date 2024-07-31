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
public class PersonServiceImpl implements  PersonService{
    @Autowired
    PersonRepositories personRepositories;

    @Transactional
    @Override
    public Person createPerson(Person person) {

        return personRepositories.save(person);
    }

    @Override
    public Person findPersonById(int id) {
        Optional<Person>opt_person = personRepositories.findById(id);
        return opt_person.get();
    }

    @Override
    public Person updatePerson(int id, Person personDetails, List<Address> addresses) {
        Optional<Person>opt_person = personRepositories.findById(id);
        Person old_person = opt_person.get();
        old_person.setPassword(personDetails.getPassword());
        old_person.setFirstName(personDetails.getFirstName());
        old_person.setLastName(personDetails.getLastName());
        old_person.getAddress().clear(); // clear existing address
        for(Address address : addresses)
        {
            address.setPerson(old_person);
        }

        old_person.setAddress(addresses);
        return personRepositories.save(old_person);
    }

    @Override
    public List<Address> getAddressByPersonId(int id) {
        Optional<Person>opt_person= personRepositories.findById(id);
        Person person = opt_person.get();
        return person.getAddress();
    }
}
