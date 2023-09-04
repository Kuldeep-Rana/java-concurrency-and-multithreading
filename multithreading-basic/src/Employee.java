import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private int empNo;
    private String name;
    private int departNo;
    private double salary;

    // empNo, departNo,
    //select e.empNo, e.departNo where e.mmpNo = (select empNo from employee having max(salary)) from employee;
    //select e.departNo, max(e.salary) from employee e group by e.departNo;



    public Employee(int empNo, String name, int departNo, double salary) {
        this.empNo = empNo;
        this.name = name;
        this.departNo = departNo;
        this.salary = salary;
    }

    public int getEmpNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public int getDepartNo() {
        return departNo;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", departNo=" + departNo +
                ", salary=" + salary +
                '}';
    }

    // depart 10
    //depart 20
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1,"kuldeep",10, 1000.00),
                new Employee(2,"rana",10, 2000.00),
                new Employee(3,"ram",20, 3000.00),
                new Employee(4,"dummy",20, 5000.00),
                new Employee(5,"test",20, 9000.00)
        );

//        employees.stream().filter(e -> e.getDepartNo() == 20).forEach(System.out::println);

        var emp = employees.stream().sorted((o1, o2) -> {
            if(o1.getSalary() < o2.getSalary())
                return 1;
            else if(o1.getSalary() > o2.getSalary())
                return -1;
            else
                return 0;
        }).toList().stream().findFirst().get();
        System.out.println(emp);

        var emp1 = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();
        System.out.println(emp1);

    }
}


