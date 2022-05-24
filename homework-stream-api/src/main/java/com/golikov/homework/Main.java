package com.golikov.homework;

import com.golikov.homework.classes.Composer;
import com.golikov.homework.classes.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(1,"Дмитрий");
        Person person2 = new Person(2,"Юрий");
        Person person3 = new Person(3,"Александр");

        List<String> listKeys = new ArrayList<>();
        List<Double> listValues = new ArrayList<>();

        List<Person> listKeys2 = new ArrayList<>();
        List<Person> listValues2 = new ArrayList<>();

        listKeys.add("1");
        listKeys.add("2");
        listKeys.add("3");

        listValues.add(1.0d);
        listValues.add(2.0d);
        listValues.add(3.0d);

        Map<String, Double> map = Composer.compose(listKeys, listValues);
        map.forEach((k, v) -> System.out.println("Ключ: "+ k +" <" + k.getClass().getSimpleName() + ">, Значение: "+ v +" <" + v.getClass().getSimpleName() + ">"));
        System.out.println("\n");

        listKeys2.add(person1);
        listKeys2.add(person2);
        //Закомментировал чтобы вызвать исключение
        //listKeys2.add(person3);

        listValues2.add(person1);
        listValues2.add(person2);
        listValues2.add(person3);


        Map<Person, Person> map2 = Composer.compose(listKeys2, listValues2);
        map2.forEach((k, v) -> System.out.println("Ключ: "+k.getId()+" <" + k.getClass().getSimpleName() + ">, Значение: "+v.getName()+" <" + v.getClass().getSimpleName() + ">"));
    }
}


