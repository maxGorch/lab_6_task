package org.example;

import java.util.*;

public class ListDemo {
    public List<Human> getNamesake(List<Human> user_list_human, Human nameSake_human)
    //TODO: Задание №2
    // Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    // и еще один объект типа Human. Результат — список однофамильцев заданного человека
    // среди людей из входного списка.
    {
        List<Human> nameSake = new ArrayList<>();
        if (user_list_human == null || user_list_human.isEmpty()) {
            throw new IllegalArgumentException("Exception: user_list_human = null or empty.");
        } else if (nameSake_human == null || nameSake_human.getSecond_name().isEmpty()) {
            throw new IllegalArgumentException("Exception: another_human = null or second name is empty.");
        } else {

            for (Human i : user_list_human) {
                if (i == null || i.getSecond_name().isEmpty()) {
                    throw new IllegalArgumentException("Exception: i = null or second name is empty.");
                } else {
                    if (i.getSecond_name().equals(nameSake_human.getSecond_name()))
                        nameSake.add(i);
                }
            }

        }
        return nameSake;
    }

    public List<Human> copyListHuman(List<Human> user_list_human, Human another_Human)
    //TODO: Задание №3
    // Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
    // входного списка, не содержащая выделенного человека. При изменении элементов
    // входного списка элементы выходного изменяться не должны.
    {
        List<Human> new_list_human = new ArrayList<>();

        if (user_list_human == null || user_list_human.isEmpty()) {
            throw new IllegalArgumentException("Exception: user_list_human = null or empty.");
        } else if (another_Human == null || another_Human.getSecond_name().isEmpty()) {
            throw new IllegalArgumentException("Exception: another_human = null or second name is empty.");
        } else {
            for (Human i : user_list_human) {
                if (i == null || i.getSecond_name().isEmpty()) {
                    throw new IllegalArgumentException("Exception: i = null or second name is empty.");
                } else {
                    new_list_human.add(new Human(
                            i.getFirst_name(),
                            i.getSecond_name(),
                            i.getLast_name(),
                            i.getAge()
                    ));
                    if (i.equals(another_Human))
                        new_list_human.remove(i);
                }
            }
        }

        return new_list_human;
    }

    public Set<Human> studentMaxAge(List<? extends Human> user_list)
    //TODO: Задание 5.2
    // Напишите метод класса ListDemo, который получает на вход список, состоящий из
    // объектов типа Human и его производных классов. Результат — множество людей из
    // входного списка с максимальным возрастом.
    {
        Set<Human> returnSet = new HashSet<>();
        if (user_list.isEmpty()) {
            throw new IllegalArgumentException("Exception user_list not empty");
        } else {
            int max = user_list.getFirst().getAge();

            for (Human i : user_list) {
                if (i == null) {
                    throw new NullPointerException("Element user_list is null!");
                } else {
                    if (i.getAge() > max) {
                        max = i.getAge();
                    }
                }
            }
            for (Human j : user_list) {
                if (j.getAge() == max) {
                    returnSet.add(new Human(
                            j.getFirst_name(),
                            j.getSecond_name(),
                            j.getLast_name(),
                            j.getAge()));
                }
            }
        }

        return returnSet;
    }

    public Set<Human> mapHumansIntersectionSet(Map<Integer, Human> mapHumans, Set<Integer> setInteger)
    //TODO: Задание №7
    // Имеется набор людей, каждому человеку задан уникальный целочисленный
    // идентификатор. Напишите метод, который получает на вход отображение (Map)
    // целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    // Результат — множество людей, идентификаторы которых содержатся во входном
    // множестве.
    {
        Set<Human> newSetHuman = new HashSet<>();
        if (mapHumans == null || mapHumans.isEmpty()) {
            throw new NullPointerException("Map is null or empty!");
        } else if (setInteger == null || setInteger.isEmpty()) {
            throw new NullPointerException("Set in argument is null or empty!");
        } else {
//            Set<Integer> keyWithIntersection = new HashSet<>();
//            Set<Integer> keysMap = mapHumans.keySet();
//            boolean flag;
//
//            for (int i : setInteger) {
//                flag = true;
//                for (int j : keysMap) {
//                    if (i == j) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag)
//                    keyWithIntersection.add(i);
//            }
            int setKeysIntersection;

            for (Integer integer : setInteger) {
                setKeysIntersection = integer;
                if (mapHumans.containsKey(setKeysIntersection)) {
                    newSetHuman.add(mapHumans.get(setKeysIntersection));
                }
            }
        }

        return newSetHuman;
    }


}
