package com.golikov.homework.classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Composer{
// метод принимает два массива произвольных типов и возвращает объект типа Map с произвольными типами ключей и значений.
    public static <T ,S> Map<T, S> compose(List<? extends T>list1, List<? extends S> list2) {
        //проверка списков по длине, если длины списков не равны, то выбрасывается исключение
        try {
            if (list1.size()!=list2.size()) {
                throw new NotEqualLengtsException(list1.size(), list2.size());
            }
        } catch (NotEqualLengtsException e){
            e.printStackTrace();
        }finally {
            Map<T, S> map = IntStream.range(0, list1.size())
                    .boxed()
                    .collect(Collectors.toMap(i -> list1.get(i), i -> list2.get(i)));
            return map;
        }
    }
}

