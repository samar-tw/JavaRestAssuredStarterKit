package com.demo.testing.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class Person {
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String jobTitle;

    public Person(String fullName, String firstName, String lastName, String address, String jobTitle) {
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.jobTitle = jobTitle;
    }

    public Person() {
        Faker faker = new Faker(new Locale("ka", "GE"));
        this.setFullName(faker.name().fullName());
        this.setFirstName(faker.name().firstName());
        this.setLastName(faker.name().lastName());
        this.setAddress(faker.address().fullAddress());
        this.setJobTitle(faker.job().title());
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public static Person createGeorgianPerson() {
        return new Person();
    }
} 