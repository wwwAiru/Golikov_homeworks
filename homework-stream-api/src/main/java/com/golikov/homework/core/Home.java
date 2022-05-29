package com.golikov.homework.core;

import java.util.ArrayList;
import java.util.List;

public class Home<T> {
    private String name;

    private List<T> inhabitants = new ArrayList<>();

    public Home() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getInhabitant() {
        try {
            if (inhabitants.isEmpty()) {
                throw new ListIsEmptyException();
            }
            else {return inhabitants;
            }
        } catch (ListIsEmptyException e){
            e.printStackTrace();
        }
        return null;
    }

    public void addInhabitantToHome(T inhabitant) {
        if (inhabitant == null) {
            inhabitants = new ArrayList<>();
        }
        inhabitants.add(inhabitant);
    }

    @Override
    public String toString() {
        return "Home{" +
                "name='" + name + '\'' +
                ", inhabitants=" + inhabitants +
                '}';
    }
}
