package com.example.demo.address;

import jakarta.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    private String address;
    private String owner;

    public Address() {
    }

    public Address(Long id, String address, String owner) {
        this.id = id;
        this.address = address;
        this.owner = owner;
    }

    public Address(String address, String owner) {
        this.address = address;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
