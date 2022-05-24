package com.golikov.homework.classes;


import java.util.List;

public class NotEqualLengtsException extends IndexOutOfBoundsException{
    int list1, list2;

    NotEqualLengtsException(int list1, int list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public String toString(){
        return "<список_1, <"+list1+"> элемента и список_2, <"+list2+"> элемента";
    }

}
