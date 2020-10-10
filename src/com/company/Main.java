package com.company;

import com.company.model.Address;
import com.company.model.Name;
import com.company.model.Person;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RelationsUtility relationsUtility = new RelationsUtility();

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(new Name("A", "A"), new Address("Address", "Address")));
        people.add(new Person(new Name("B", "B"), new Address("Address", "Address")));
        people.add(new Person(new Name("A", "A"), new Address("Address1", "Address1")));
        people.add(new Person(new Name("C", "C"), new Address("Address1", "Address1")));
        people.add(new Person(new Name("D", "D"), new Address("Address1", "Address1")));

        Person personBlah = new Person(new Name("blah", "blah"), new Address("blah", "blah"));
        people.add(personBlah);
        people.add(new Person(new Name("blah2", "blah2"), new Address("blah", "blah")));
        people.add(new Person(new Name("blah3", "blah3"), new Address("blah", "blah")));

        people.add(new Person(new Name("2", "2"), new Address("Address", "Address")));
        people.add(new Person(new Name("2", "2"), new Address("3", "3")));
        people.add(new Person(new Name("4", "4"), new Address("3", "3")));
        people.add(new Person(new Name("4", "4"), new Address("5", "5")));
        Person person6 = new Person(new Name("5", "5"), new Address("5", "5"));
        people.add(person6);

        relationsUtility.init(people);

        System.out.println("A A -> A A: " + relationsUtility.findMinRelationLevel(people.get(0), people.get(0)));
        System.out.println("A A -> B B: " + relationsUtility.findMinRelationLevel(people.get(0), people.get(1)));
        System.out.println("A A -> C C: " + relationsUtility.findMinRelationLevel(people.get(0), people.get(3)));
        System.out.println("A A -> D D: " + relationsUtility.findMinRelationLevel(people.get(0), people.get(4)));
        System.out.println("A A -> 5 5: " + relationsUtility.findMinRelationLevel(people.get(0), person6));
        System.out.println("A A -> blah blah: " + relationsUtility.findMinRelationLevel(people.get(0), personBlah));
    }

}
