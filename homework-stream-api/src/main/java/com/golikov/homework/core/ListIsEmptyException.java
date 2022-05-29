package com.golikov.homework.core;


public class ListIsEmptyException extends NullPointerException{

    @Override
    public String toString(){
        return "Список обитателей дома пуст";
    }

}
