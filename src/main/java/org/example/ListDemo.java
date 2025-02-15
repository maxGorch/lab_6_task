package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListDemo
//TODO: Напишите метода класса ListDemo, который получает на вход список объектов типа Human
// и еще один объект типа Human. Результат — список однофамильцев заданного человека
// среди людей из входного списка.
{
    public List<Human> getNamesake(List<Human> user_list_human, Human another_human)
    {
        List<Human> nameSake = new ArrayList<>();
        if(user_list_human == null || user_list_human.isEmpty())
        {
            throw new IllegalArgumentException("Exception: user_list_human = null or empty.");
        }
        else if(another_human == null||another_human.getSecond_name().isEmpty())
        {
            throw new IllegalArgumentException("Exception: another_human = null or second name is empty.");
        }
        else{
            for (Human i: user_list_human)
            {
                if(i == null || i.getSecond_name().isEmpty())
                {
                    throw new IllegalArgumentException("Exception: i = null or second name is empty.");
                }
                else{
                    if(i.getSecond_name().equals(another_human.getSecond_name()))
                        nameSake.add(i);
                }
            }
        }

        return nameSake;
    }
}
