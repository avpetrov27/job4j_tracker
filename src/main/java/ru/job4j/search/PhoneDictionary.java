package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> getName = (p) -> p.getName().contains(key);
        Predicate<Person> getSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> getPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> getAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> combine = getName.or(getSurname).or(getPhone).or(getAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
