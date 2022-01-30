package com.oleg.pakhomov.ex2;

public class Citizen extends Person{
    private String city;
    private String country;


    public  Citizen(String name, int age, String city, String country) {
        super(name, age);
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    public String toString(){
        return "Имя " + getName() + "\nВозраст " + getAge() +
                "\nГород " + city + "\nСтрана " + country;
    }
}
