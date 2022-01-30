package com.oleg.pakhomov.ex2;

public class Employee extends Citizen {
    private String work;

    public Employee(String name, int age, String city, String country, String work) {
        super(name, age, city, country);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public String toString(){
        return "Имя " + getName() + "\nВозраст " + getAge() +
                "\nГород " + getCity() + "\nСтрана " + getCountry() +
                "\nРабота " + work;
    }
}
