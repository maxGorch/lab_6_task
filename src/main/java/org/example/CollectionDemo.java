package org.example;

import java.util.List;

public class CollectionDemo
//TODO:
// Вход: список строк и символ.
// Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
{
    public int amountString(List<String> user_list, char user_char) {
        int counter =0;
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
}
