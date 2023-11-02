package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Employee {
    private static int idCounter = 1;

    @Id
    private int id;
    private String name;
    private int age;
    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}







