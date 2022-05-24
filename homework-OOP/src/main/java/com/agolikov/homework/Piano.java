package com.agolikov.homework;

public class Piano extends MusicalInstrument implements Playable {

    public Piano(int id, String name) {
        super(id, name);
    }


    @Override
    public void play() {
        System.out.println("Пианино "+ super.getName() +" играет.");
    }

}
