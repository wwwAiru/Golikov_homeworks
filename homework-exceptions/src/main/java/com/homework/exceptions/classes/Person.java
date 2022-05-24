package com.homework.exceptions.classes;

public class Person {
    private int id, age;

    public Person(int id, int age, String name) {
        this.id = id;
        try {
            this.age = age;
            if (age<=0) throw new IncorrectAgeException(age);
        } catch (Exception e) {
            e.printStackTrace();
            this.age = 1;
        }
        this.name = name;
    }

    public Person() {
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try {
            this.age = age;
            if (age<=0) throw new IncorrectAgeException(age);
        } catch (Exception e) {
            e.printStackTrace();
            this.age = 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
