package org.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Amila", GENDER.MALE),
                new Person("Jane", GENDER.FEMALE),
                new Person("Akila", GENDER.MALE),
                new Person("Sumudu", GENDER.FEMALE),
                new Person("Nayanaa", GENDER.FEMALE)
        );

        // imperative approach : every single details in the code | lot of code lines
        List<Person> females = new ArrayList<>();
        for (Person person : persons){
            if(person.gender.equals(GENDER.FEMALE)) females.add(person);
        }
        for (Person female : females){
            System.out.println(female.toString());
        }

        // declaretive approach : e
        persons.stream()
                .filter(person -> (person.gender.equals(GENDER.FEMALE)))
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> person.gender.equals(GENDER.FEMALE);
        persons.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final GENDER gender;

        public Person(String name, GENDER gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name : "+ this.name +
                    " , " +
                    "gender : "+ this.gender +
                    "}";
        }
    }

    enum GENDER{
        MALE, FEMALE
    }
}