package com.codersdesks;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Java8Example {
    public static void main(String[] args) {
        var users = UserDataFactory.getUsers();
        //System.out.println("Users grouped by department: "+groupUserByDepartment(users));
        //System.out.println("Users sorted by created on: "+sortByCreatedOn(users));
       // System.out.println("Users department list: "+getDepartmentList(users));
        //System.out.println("unique Users department list: "+getUniqueDepartmentList(users));
        //System.out.println("Users by salary GT 5000: "+getUserBySalaryGT5000(users));
        //System.out.println("Users group by salary LT 5000 AND GT 5000: "+groupUserBySalaryLT5000AndGT5000(users));
        //System.out.println("Users by salary LT 5000 AND GT 5000 LT 10000 AND GT 10000: "+groupUserBySalaryLT5000AndGT5000WithCustomMessage(users));

        users.stream().limit(2).toList().forEach(System.out::println);
        System.out.println("===============================================");
        users.stream().skip(2).toList().forEach(System.out::println);
        System.out.println("===============================================");
        users.stream().peek(user -> departmentToLowerCase(user)).forEach(System.out::println);

        //reduce to get sum of salary
        double salary = users.stream().mapToDouble(User::getSalary).reduce(0,(sal1,sal2) -> sal1+sal2);
        System.out.println("salary sum: "+salary);
    }
    static void departmentToLowerCase(User u){
        u.setDepartment(u.getDepartment().toLowerCase());
    }
    static Map<String, List<User>> groupUserByDepartment(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::getDepartment));
    }
    static List<User> sortByCreatedOn(List<User> users){
        return users.stream().sorted((o1, o2) -> o1.getCreatedOn().compareTo(o2.createdOn)).toList();
    }
    static List<String> getDepartmentList(List<User> users){
        return users.stream().map(User::getDepartment).toList();
    }
    static List<String> getUniqueDepartmentList(List<User> users){
        return users.stream().map(User::getDepartment).distinct().toList();
    }
    static List<User> getUserBySalaryGT5000(List<User> users){
        return users.stream().filter(u-> u.getSalary() > 5000.00).toList();
    }
    static Map<Boolean, List<User>> groupUserBySalaryLT5000AndGT5000(List<User> users){
        return users.stream().collect(Collectors.partitioningBy(u ->u.getSalary() > 5000));
    }
    static Map<String, List<User>> groupUserBySalaryLT5000GT5000LT10000ANDGT10000WithCustomMessage(List<User> users){
        return users.stream().collect(Collectors.groupingBy(u -> {
            if(u.getSalary() <= 5000){
                return "LT 5000";
            }if(u.getSalary() > 5000 && u.getSalary() < 10000){
                return "GT 5000 LT 10000";
            }
            else
                return "GT 10000";
        }));
    }

}

class User{
    int id;
    String name;
    String department;
    LocalDate createdOn;
    double salary;

    public User(int id, String name, String department, LocalDate createdOn, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.createdOn = createdOn;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public double getSalary() {
        return salary;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", createdOn=" + createdOn +
                ", salary=" + salary +
                '}';
    }
}

class UserDataFactory{
    static List<User> getUsers(){
        return List.of(
                new User(1,"kuldeep","IT",LocalDate.of(2021,12,30),1000.00),
                new User(1,"Ajay","CIVIL",LocalDate.of(2022,12,30),2000.00),
                new User(1,"Kapil","IT",LocalDate.of(2023,12,30),3000.00),
                new User(1,"Manoj","ELECTRIC",LocalDate.of(2020,12,30),4000.00),
                new User(1,"Gauransh","SCHOOL",LocalDate.of(2019,12,30),5000.00),
                new User(1,"Deepa","PROFESSIONAL",LocalDate.of(1989,12,30),60000.00),
                new User(1,"Sharey","SCHOOL",LocalDate.of(1943,12,30),9000.00),
                new User(1,"Aadvik","SCHOOL",LocalDate.of(1999,12,30),20000.00)

        );
    }
}
