package com.test;

import java.util.List;

public class Employee {

    private List<String> skills;

    private String name;

    private int hours;
    public Employee(){

    }

    public Employee(List<String> skills, int hours, String name) {
        this.skills = skills;
        this.hours = hours;
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
