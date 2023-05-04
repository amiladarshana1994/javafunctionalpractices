package org.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Amila", GENDER.MALE),
                new Person("Jane", GENDER.FEMALE),
                new Person("Akila", GENDER.MALE),
                new Person("Sumudu", GENDER.FEMALE),
                new Person("Nayanaa", GENDER.FEMALE)
        );

        System.out.println("Map gender to list");
        persons.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Map gender to set to remove duplicates");
        persons.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        Predicate<Person> isFemale = person -> person.gender.equals(GENDER.FEMALE);

        boolean isAllFemales = persons.stream().allMatch(isFemale);
        System.out.println("isAllFemales : "+isAllFemales);

        boolean isAnyFemales = persons.stream().anyMatch(isFemale);
        System.out.println("isAnyFemales : "+isAnyFemales);

        boolean isAllFemalesInFilter = persons.stream().filter(isFemale).allMatch(isFemale);
        System.out.println("isAllFemalesInFilter : "+isAllFemalesInFilter);
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
