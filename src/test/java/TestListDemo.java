import org.example.Human;
import org.example.ListDemo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestListDemo
//TODO: Результат — список однофамильцев заданного человека
// среди людей из входного списка.
{
    List<Human> test_list = new ArrayList<>();
    ListDemo test = new ListDemo();
    Human product_1 = new Human("Иван", "Иванов", "Иваныч", 18);
    Human product_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Human product_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Human product_another = new Human("Игорь", "Иванов", "Петрович", 25);
    Human product_another_empty = new Human("Руслан", "", "Максимович", 16);
    List<Human> nameSake = new ArrayList<>();


    @Test
    public void test_first_allGood()
    //Тест где все работает
    {
        test_list.add(product_1);
        test_list.add(product_2);
        test_list.add(product_3);

        for (Human i : test_list) {
            if (i.getSecond_name().equals(product_another.getSecond_name())) {
                nameSake.add(i);
            }
        }
        assertEquals(nameSake, test.getNamesake(test_list, product_another), "Должен получится список однофамильцев");
    }

    @Test
    public void test_second_nullException()
    //Тест где все работает
    {
        test_list.add(null);
        test_list.add(product_2);
        test_list.add(null);

        assertThrows(IllegalArgumentException.class, () ->
        {
            test.getNamesake(test_list, product_another);
            test.getNamesake(test_list, null);
            test.getNamesake(test_list, product_another_empty);
        },"Мы должны получить исключение за счет null эл-ов в списке!");
    }
}
