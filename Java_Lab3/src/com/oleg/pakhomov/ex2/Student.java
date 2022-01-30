package com.oleg.pakhomov.ex2;


public class Student extends Citizen{
    private String university;
    private int course;

    public Student(String name, int age, String city, String country, String university, int course){
        super(name, age, city, country);
        this.university = university;
        this.course = course;
    }

    public String getUniversity() {
        return university;
    }

    public int getCourse() {
        return course;
    }
    public String toString(){
        return "Имя " + getName() + "\nВозраст " + getAge() +
                "\nГород " + getCity() + "\nСтрана " + getCountry() +
                "\nУниверситет " + university + "\nКурс " + course;
    }
}
