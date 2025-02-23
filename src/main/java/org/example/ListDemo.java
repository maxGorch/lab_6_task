package org.example;

import java.util.ArrayList;
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
        /*
        arg: FinanceReport obj
        Payment[] new_payments = new Payment[obj.getLengthPayments()];
            Payment old_payment;
            for (int i = 0; i < new_payments.length; i++) {
                old_payment = obj.getIndexPayments(i);
                new_payments[i] = new Payment(
                        old_payment.getSNM(),
                        old_payment.getPayment_date(),
                        old_payment.getMonth(),
                        old_payment.getYear(),
                        old_payment.getPayment_amount()
                );

            }
        */
    }

}
