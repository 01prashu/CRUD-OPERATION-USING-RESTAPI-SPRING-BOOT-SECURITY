package com.example.Register_Login.controller;

import com.example.Register_Login.model.Address;
import com.example.Register_Login.model.Person;
import com.example.Register_Login.service.PersonService;
import com.example.Register_Login.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> createUser(@RequestBody Person person)
    {
        try {
            Person created_Person = personService.createPerson(person);
            return  ResponseEntity.ok(created_Person);
        }
        catch (Exception e)
        {
            System.out.println(e.fillInStackTrace()+" "+e.getMessage());

        }
        return null;
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person,@PathVariable("id") int id, @RequestParam List<Address>addresses)
    {
        Person update = personService.updatePerson(id,person,addresses);
        return  ResponseEntity.ok(update);
    }


}
