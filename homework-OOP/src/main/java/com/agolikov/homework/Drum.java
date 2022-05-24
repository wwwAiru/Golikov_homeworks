package com.agolikov.homework;

public class Drum extends MusicalInstrument implements Playable{

    public Drum(int id, String name) {
        super(id, name);
    }


    @Override
    public void play() {
        System.out.println("Барабан "+ super.getName() +" играет.");
    }
}
