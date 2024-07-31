package com.example.Register_Login.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true , name = "person_email")
    private String email;
    @Column(name = "person_password")
    private String password;
    private String firstName;
    private String lastName;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address;

    public Person(int id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  void setAddress(List<Address>address)
    {
        this.address = address;
    }
    public  List<Address> getAddress()
    {
        return this.address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id +
                ", email='" + this.email + '\'' +
                ", password='" + this.address + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", addresse='"+this.address+'\''+
                '}';
    }
}
