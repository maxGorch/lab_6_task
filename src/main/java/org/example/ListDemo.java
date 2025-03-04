package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public List<Human> getNamesake(List<Human> user_list_human, Human nameSake_human)
    //TODO: Напишите метода класса ListDemo, который получает на вход список объектов типа Human
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
    //TODO: Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
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

    public List<? extends Human> studentMaxAge(List<? extends Human> user_list)
    //TODO: Напишите метод класса ListDemo, который получает на вход список, состоящий из
    // объектов типа Human и его производных классов. Результат — множество людей из
    // входного списка с максимальным возрастом.
    {
        List<Human> returnList = new ArrayList<>();
        if(user_list.isEmpty())
        {
            throw new IllegalArgumentException("Exception user_list not empty");
        }
        else{
            int max = user_list.getFirst().getAge();

            for (Human i: user_list)
                if (i.getAge() > max) {
                    max = i.getAge();
                }

            for (Human j: user_list)
            {
                if (j.getAge() == max) {
                    returnList.add(new Human(
                            j.getFirst_name(),
                            j.getSecond_name(),
                            j.getLast_name(),
                            j.getAge()));
                }
            }
        }

        return returnList;
    }

}
