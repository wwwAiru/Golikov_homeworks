package com.agolikov.homework;

public class Radio implements Playable {
    double wave;
    String model;

    @Override
    public void play() {
        System.out.println("На радиоволне "+ wave +" играет музыка.");
    }

    public Radio (String model, double wave) {
        this.model = model;
        this.wave = wave;
    }
}
