package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionDemo
//TODO:
// Вход: список строк и символ.
// Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        List<String> list_Str = new ArrayList<>();
        System.out.println("Введите символ: ");
        char user_char = (char) System.in.read();

        System.out.println(user_char + "\nВведите значение строк: ");
        String str_1 = in.next();
        String str_2 = in.next();
        String str_3 = in.next();

        list_Str.add(str_1);
        list_Str.add(str_2);
        list_Str.add(str_3);
        for (String i : list_Str) {
            if (i.charAt(0) == user_char)
                System.out.print(i);
        }

        in.close();
    }

    public StringBuilder amountString(List<String> user_list, char user_char) {
        StringBuilder str = new StringBuilder();
        if (user_list == null || user_char == '\u0000') {
            throw new IllegalArgumentException("Exception: user char = null or user list = null");
        } else {
            for (String i : user_list) {
                if (i == null || i.isEmpty()) {
                    throw new IllegalArgumentException("Exception: i = null or empty");
                } else {
                    if (i.charAt(0) == user_char)
                        str.append(i);
                }
            }
        }
        return str;
    }
}
