package com.example.Register_Login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_Id")
    private int id;
    @Setter
    @Column(name="city")
    private String city;
    @Setter
    @Column(name="state")
    private String state;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "person_id")
    private Person person;
    public Address(int id, String city, String state) {
        this.id = id;
        this.city = city;
        this.state = state;
    }

    public Address() {
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
