package com.oleg.pakhomov.ex2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person [] pers = {
                new Person("Guy",20),
                new Citizen("Alex", 16,"Brest","Belarus"),
                new Employee("Vlad",19,"Lviv","Ukraine","Loyer"),
                new Student("Alex", 22, "Kharkiv", "Ukraine", "KArazina", 3)
        };
        for (Person person : pers){
            System.out.println(person + "\n");
        }
    }
}
