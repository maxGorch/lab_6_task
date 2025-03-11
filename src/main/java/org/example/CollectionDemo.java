package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionDemo {

    public int amountString(List<String> user_list, char user_char)
    //TODO: Задание №1
    // Вход: список строк и символ.
    // Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
    {
        int counter = 0;
        if (user_list == null || user_char == '\u0000') {
            throw new IllegalArgumentException("Exception: user char = null or user list = null");
        } else {
            for (String i : user_list) {
                if (i == null || i.isEmpty()) {
                    throw new IllegalArgumentException("Exception: i = null or empty");
                } else {
                    if (i.charAt(0) == user_char)
                        counter++;
                }
            }
        }
        return counter;
    }

    public List<Set<Integer>> intersectionMultitude(List<Set<Integer>> multitudeInteger, Set<Integer> anotherMultitude)
    //TODO: Задание №4
    // Вход: список множеств целых чисел и еще одно множество.
    // Выход: список всех множеств входного списка, которые не пересекаются с заданным множеством.
    {
        List<Set<Integer>> intersectionMultitude = new ArrayList<>();
        if (multitudeInteger.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        } else if (anotherMultitude == null) {
            throw new IllegalArgumentException("Array is null");
        } else {
            for (Set<Integer> el : multitudeInteger) {
                if(el == null)
                {
                    throw new NullPointerException("Elements in List maybe null!");
                }
                else{
                    boolean flag = true;
                    for (int i : anotherMultitude) {
                        for (int j : el) {
                            if (i == j) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag)
                        intersectionMultitude.add(el);
                }
            }
        }

        return intersectionMultitude;
    }
}
