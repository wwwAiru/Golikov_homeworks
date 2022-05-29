package com.golikov.homework;

import com.golikov.homework.core.Animal;
import com.golikov.homework.core.Home;
import com.golikov.homework.core.Person;

public class Main2 {
    public static void main(String[] args) {
        Home home = new Home();
        home.setName("Дом");
        Person person = new Person(1, "Иван");
        Animal cat = new Animal("Вася");
        Animal dog = new Animal("Габи");
        // закомменнтировать три строки вниз чтобы вызвать исключение
        home.addInhabitantToHome(cat);
        home.addInhabitantToHome(dog);
        home.addInhabitantToHome(person);
        home.getInhabitant().stream().forEach(System.out::println);
    }
}
