package com.codersdesks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Department {
    String name;
    List<User> users;
    public Department(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
public class Java8FlatMapExample {
    public static void main(String[] args) {
        Department hrDept = new Department("HR");
        hrDept.addUser(new User(1, "Alice", "HR", LocalDate.of(2023, 8, 1), 50000));
        hrDept.addUser(new User(2, "Bob", "HR", LocalDate.of(2023, 8, 1), 55000));

        Department itDept = new Department("IT");
        itDept.addUser(new User(3, "Charlie", "IT", LocalDate.of(2023, 8, 1), 60000));
        itDept.addUser(new User(4, "David", "IT", LocalDate.of(2023, 8, 1), 65000));

        List<Department> departments = Arrays.asList(hrDept, itDept);
        departments.forEach(System.out::println);
        System.out.println("=======================================================");
        List<User> allUsers = departments.stream()
                .flatMap(dept -> dept.users.stream())
                .collect(Collectors.toList());

        allUsers.forEach(System.out::println);

        var numbers = List.of(List.of(1,2,3),List.of(4,5,6),List.of(7,8,9));
        numbers.stream().flatMap(nums -> nums.stream()).toList().forEach(System.out::print);


        List<Optional<String>> optionalValues = Arrays.asList(
                Optional.of("Value 1"),
                Optional.empty(),
                Optional.of("Value 2")
        );
        System.out.println();
        List<String> nonEmptyValues = optionalValues.stream()
                .flatMap(opt -> opt.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());
        System.out.println("nonEmptyValues "+nonEmptyValues);
    }
}

