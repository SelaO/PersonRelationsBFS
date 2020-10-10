package com.company.model;

import java.util.Objects;

public class Person {
    private Name name;
    private Address address;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Person() {
    }

    public String getNameKey() {
        return name.toString();
    }

    public String getAddressKey() {
        return address.toString();
    }

    public Person(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
