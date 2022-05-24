package com.homework.exceptions;

import com.homework.exceptions.classes.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alex");
        person.setId(1);
        person.setAge(0);
        System.out.println(person.toString());
    }
}
