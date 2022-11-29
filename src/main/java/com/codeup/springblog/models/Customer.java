package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customers_coffees",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "coffee_id")}
    )
    private List<Coffee> coffeeList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffees) {
        this.coffeeList = coffees;
    }

    public Customer(List<Coffee> coffees) {
        this.coffeeList = coffees;
    }

}

