package com.agolikov.homework;

public class Violin extends MusicalInstrument implements Playable{

    public Violin (int id, String name) {
        super(id, name);
    }


    @Override
    public void play() {
        System.out.println("Скрипка "+ super.getName() +" играет.");
    }
}
