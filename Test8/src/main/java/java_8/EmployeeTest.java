package java_8;

import java.util.*;
import java.util.stream.Collectors;

class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
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

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }


}

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        //Find out the count of male and female employees present in the organization?
        Map<String, Long> noOfMaleAndFemaleEmployees =
                employeeList.stream()
                        .collect(Collectors.groupingBy
                                (Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);

        System.out.println("-------------------------------------------------");

        //Write a program to print the names of all departments in the organization.

        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");


        //Find the average age of Male and Female Employees.
        Map<String, Double> avgAge = employeeList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getGender,
                                Collectors.averagingInt
                                        (Employee::getAge)));
        System.out.println(avgAge);

        System.out.println("-------------------------------------------------");

        //Get the Names of employees who joined after 2015.
        employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        //Count the number of employees in each department.
        Map<String, Long> countByDept = employeeList.stream().collect(Collectors.groupingBy
                (Employee::getDepartment,
                        Collectors.counting()));
        Set<Map.Entry<String, Long>> entrySet = countByDept.entrySet();
        for (Map.Entry<String, Long> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-------------------------------------------------");

        //Find out the average salary of each department.
        Map<String, Double> avgSalary = employeeList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String, Double>> entrySet1 = avgSalary.entrySet();
        for (Map.Entry<String, Double> entry : entrySet1) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-------------------------------------------------");


        //Find out the oldest employee, his/her age and department?

        Optional<Employee> oldestEmp = employeeList.stream()
                .max(Comparator
                        .comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmp .get();

        System.out.println("Name : "+oldestEmployee.getName());
        System.out.println("Age : "+oldestEmployee.getAge());
        System.out.println("Department : "+oldestEmployee.getDepartment());

        System.out.println("-------------------------------------------------");


        //Find out the average and total salary of the organization.
        DoubleSummaryStatistics empSalary = employeeList.stream()
                .collect(Collectors
                        .summarizingDouble(Employee::getSalary));

        System.out.println("Average Salary = "+empSalary.getAverage());
        System.out.println("Total Salary = "+empSalary.getSum());

        System.out.println("-------------------------------------------------");

        //List down the employees of each department.

        Map<String, List<Employee>> empList = employeeList.stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment));

        Set<Map.Entry<String, List<Employee>>> entrySet2 = empList.entrySet();

        for (Map.Entry<String, List<Employee>> entry : entrySet2)
        {
            System.out.println("--------------------------------------");
            System.out.println("Employees In "+entry.getKey() + " : ");
            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();
            for (Employee e : list)
            {
                System.out.println(e.getName());
            }
        }

        System.out.println("-------------------------------------------------");

        //Find out the highest experienced employees in the organization
        Optional<Employee> seniorEmp = employeeList.stream()
                .sorted(Comparator
                        .comparingInt(Employee::getYearOfJoining)).findFirst();

        Employee seniorMostEmployee = seniorEmp.get();

        System.out.println("Senior Most Employee Details :");
        System.out.println("----------------------------");
        System.out.println("ID : "+seniorMostEmployee.getId());
        System.out.println("Name : "+seniorMostEmployee.getName());
        System.out.println("Age : "+seniorMostEmployee.getAge());

        System.out.println("-------------------------------------------------");




    }
}