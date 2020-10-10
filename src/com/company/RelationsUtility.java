package com.company;

import com.company.model.Person;
import javafx.util.Pair;

import java.util.*;

public class RelationsUtility {

    private final HashMap<String, List<Person>> peopleMap = new HashMap<>();
    private final List<Person> peopleList = new ArrayList<>(); // for easy reset

    public void init(List<Person> people) {

        for (Person person : people) {
            if (!peopleMap.containsKey(person.getNameKey())) {
                ArrayList<Person> arr = new ArrayList<>();
                arr.add(person);
                peopleMap.put(person.getNameKey(), arr);
            } else {
                peopleMap.get(person.getNameKey()).add(person);
            }

            if (!peopleMap.containsKey(person.getAddressKey())) {
                ArrayList<Person> arr = new ArrayList<>();
                arr.add(person);
                peopleMap.put(person.getAddressKey(), arr);
            } else {
                peopleMap.get(person.getAddressKey()).add(person);
            }

            ArrayList<Person> arr = new ArrayList<>();
            arr.add(person);
            peopleMap.put(person.getNameKey() + person.getAddressKey(), arr); // assuming this key is unique, this is for O(1) retrieval

            peopleList.add(person);
        }
    }

    public int findMinRelationLevel(Person personA, Person personB) {
        if (personA.equals(personB)) {
            return 0;
        }

        Queue<Pair<Person, Integer>> queue = new LinkedList<>();

        resetVisited();

        List<Person> people = peopleMap.get(personA.getNameKey() + personA.getAddressKey());
        people.get(0).setVisited(true);
        int level = 0;

        HashSet<String> seenKeys = new HashSet<>();

        buildNextLevel(personA, queue, seenKeys, level);

        // BFS
        while (!queue.isEmpty()) {
            Pair<Person, Integer> currPersonKeyValue = queue.poll();
            Person currPerson = currPersonKeyValue.getKey();

            if (currPerson.equals(personB)) {
                return currPersonKeyValue.getValue();
            }

            if (!currPerson.isVisited()) {
                currPerson.setVisited(true);
                buildNextLevel(currPerson, queue, seenKeys, currPersonKeyValue.getValue());
            }
        }

        return -1;
    }

    private void resetVisited() {
        for (Person person : peopleList) {
            person.setVisited(false);
        }
    }

    private void buildNextLevel(Person currPerson, Queue<Pair<Person, Integer>> queue, HashSet<String> seenKeys, int level) {
        ArrayList<Person> tempArr = new ArrayList<>();
        if (!seenKeys.contains(currPerson.getNameKey())) {
            tempArr.addAll(peopleMap.get(currPerson.getNameKey()));
            seenKeys.add(currPerson.getNameKey());
        }
        if (!seenKeys.contains(currPerson.getAddressKey())) {
            tempArr.addAll(peopleMap.get(currPerson.getAddressKey()));
            seenKeys.add(currPerson.getAddressKey());
        }

        for (Person person : tempArr) {
            queue.add(new Pair<>(person, level + 1));
        }
    }
}
