package com.agolikov.homework;

public class Guitar extends MusicalInstrument implements Playable {

    public Guitar(int id, String name) {
        super(id, name);
    }


    @Override
    public void play() {
        System.out.println("Гитара "+ super.getName() +" играет.");
    }
}
