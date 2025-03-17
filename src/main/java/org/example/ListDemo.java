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
        Set<Human> newSetHuman;

        if (mapHumans.isEmpty()) {
            throw new NullPointerException("Map is empty!");
        } else if (setInteger.isEmpty()) {
            throw new NullPointerException("Set in argument is empty!");
        } else {
            newSetHuman = new HashSet<>();
            int setKeysIntersection;

            for (Integer integer : setInteger) {
                if (integer == null)
                    throw new NullPointerException("Elements in Set is null!");
                setKeysIntersection = integer;
                if (mapHumans.containsKey(setKeysIntersection)) {
                    newSetHuman.add(mapHumans.get(setKeysIntersection));
                }
            }
        }

        return newSetHuman;
    }

    public List<Integer> mapHumansAverageAge18(Map<Integer, Human> mapHumans)
    //TODO: Задание №8
    // Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не
    // менее 18 лет.
    {
        List<Integer> newSetHuman = new ArrayList<>();
        if (mapHumans.isEmpty()) {
            throw new NullPointerException("Map is empty!");
        } else {
            Integer keyMap;
            Human valueMap;
            for (Map.Entry<Integer, Human> entry : mapHumans.entrySet()) {
                keyMap = entry.getKey();
                if (keyMap == null)
                    throw new NullPointerException("Elements in map is null (ID)");
                valueMap = entry.getValue();
                if (valueMap == null)
                    throw new NullPointerException("Elements in map is null (Human)");
                if (valueMap.getAge() > 18 || valueMap.getAge() == 18) {
                    newSetHuman.add(keyMap);
                }
            }

        }
        return newSetHuman;
    }

    public Map<Integer, Integer> newMapHumansWithAge(Map<Integer, Human> mapHumans)
    //TODO: Задание №9
    //  Для отображения из задачи 7 постройте новое отображение, которое идентификатору
    //  cопоставляет возраст человека.
    {
        Map<Integer, Integer> newMapHuman = new HashMap<>();
        if (mapHumans.isEmpty()) {
            throw new NullPointerException("Map is null or empty!");
        } else {
            Integer keyMap;
            Human valueMap;
            for (Map.Entry<Integer, Human> entry : mapHumans.entrySet()) {
                keyMap = entry.getKey();
                if (keyMap == null)
                    throw new NullPointerException("Elements in map is null (ID)");
                valueMap = entry.getValue();
                if (valueMap == null)
                    throw new NullPointerException("Elements in map is null (Human)");
                newMapHuman.put(keyMap, valueMap.getAge());
            }

        }
        return newMapHuman;
    }

    public Map<Integer, List<Human>> newMapAgeHumans(Set<Human> setHuman)
    //TODO: Задание №10
    // По множеству объектов типа Human постройте отображение, которое целому числу
    // (возраст человека) сопоставляет список всех людей данного возраста из входного
    // множества.
    {
        Map<Integer, List<Human>> newMapHuman = new TreeMap<>();
        if (setHuman.isEmpty()) {
            throw new IllegalArgumentException("Map is null or empty!");
        } else {
            List<Human> listHumans;
            for (Human i : setHuman) {
                if (i == null)
                    throw new NullPointerException("Elements in map is null (Human)");
                else if (newMapHuman.containsKey(i.getAge()))
                    newMapHuman.get(i.getAge()).add(i);
                else {
                    listHumans = new ArrayList<>();
                    listHumans.add(i);
                    newMapHuman.put(i.getAge(), listHumans);
                }
            }
        }
        return newMapHuman;
    }
}
