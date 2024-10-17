package com.test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class Test {
    public static void main(String[] args) {


        List<String> aliceSkills = new ArrayList<>();
        aliceSkills.add("java");
        aliceSkills.add("python");


        List<String> bobSkills = new ArrayList<>();
        bobSkills.add("python");
        bobSkills.add("sql");

        List<String> charlieSkills = new ArrayList<>();
        charlieSkills.add("java");


        Map<String, Integer> map = new HashMap<>();
        map.put("java", 25);
        map.put("python", 20);
        map.put("sql", 18);


        Employee e = new Employee(aliceSkills, 40, "Alice");
        Employee e1 = new Employee(bobSkills, 35, "Bob");
        Employee e2 = new Employee(charlieSkills, 30, "Charlie");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e);
        employeeList.add(e1);
        employeeList.add(e2);
        Map<String, Integer> totalPays = totalPay(employeeList, map);
        totalPays = totalPays.entrySet().stream().sorted(comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(k,v)->v, LinkedHashMap::new));
        System.out.println(totalPays);
    }
// n = number of entries , n + (n log n), due to merge sort n (n log n)


    public static Map<String, Integer> totalPay(List<Employee> employees, Map<String, Integer> map) {
        Map<String, Integer> total = new HashMap();
        for (Employee e : employees) {
            int totalPay = 0;

            for (String s : e.getSkills()) {
                if (map.containsKey(s)) {
                    int pay = map.get(s) * e.getHours();
                    totalPay += pay;
                }
            }
            total.put(e.getName(), totalPay);
        }

        return total;
    }
}
