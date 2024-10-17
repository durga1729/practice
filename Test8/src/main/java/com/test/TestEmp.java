package com.test;

import java.util.*;

public class TestEmp {
    public static void main(String[] args) {
        Address address = new Address("hyd", "mvp", 123);
        Person employee = new Person(101, "prasad", address);

        Address address1 = new Address("vizag", "begumpet", 569);
        Person employee1 = new Person(202, "durga", address1);

        List<Person> personList = new ArrayList<>();
        personList.add(employee);
        personList.add(employee1);



     //   System.out.println(map);
    }
}
