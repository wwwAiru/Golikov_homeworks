package com.homework.exceptions.classes;

public class IncorrectAgeException extends Exception{

    int value;

    public IncorrectAgeException(int _value) {
        value = _value;
    }

    @Override
    public String toString() {
        return "IncorrectAgeException " +
                "value = " + value +
                " возраст не может быть меньше или равен нулю";
    }
}
