package com.codersdesks;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault()));
        List<Person> personList = List.of(
                new Person(1, "Alice", 25),
                new Person(2, "Bob", 30),
                new Person(3, "Alice", 28) ,
                new Person(3, "Alice", 35)
        );

        var personMap = personList.stream()
                .collect(Collectors.groupingBy(Person::getId));

        System.out.println(personMap);
    }
}
class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
