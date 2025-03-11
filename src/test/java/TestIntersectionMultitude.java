import org.example.CollectionDemo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestIntersectionMultitude {
    CollectionDemo test = new CollectionDemo();
    List<Set<Integer>> test_list = new ArrayList<>();
    List<Set<Integer>> test_list_null = null;
    Set<Integer> el1 = new HashSet<>();
    Set<Integer> el2 = new HashSet<>();
    Set<Integer> el3 = new HashSet<>();
    Set<Integer> el_null = null;
    Set<Integer> anotherMultitude = new HashSet<>();
    Set<Integer> anotherNullMultitude = null;

    @Test
    public void test_first() {
        // Добавление элементов
        el1.add(1);
        el1.add(2);
        el1.add(3);
        test_list.add(el1);
        el2.add(4);
        el2.add(5);
        el2.add(6);
        el2.add(7);
        test_list.add(el2);
        el3.add(8);
        el3.add(9);
        test_list.add(el3);
        //Добавление элементов в множество которое является условием пересечения
        anotherMultitude.add(11);
        anotherMultitude.add(12);
        anotherMultitude.add(13);

        //Новый список множеств, который будет заполнять с условием пересечения
        List<Set<Integer>> intersectionMultitude = new ArrayList<>();
        boolean flag;
        for (Set<Integer> el : test_list) {
            flag = true;
            for (Integer i : anotherMultitude) {
                for (int j : el) {
                    if (i == j) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                intersectionMultitude.add(el);
            }
        }

        System.out.println("Expected: " + Arrays.deepToString(intersectionMultitude.toArray()));
        System.out.println("Actual: " + Arrays.deepToString(test.intersectionMultitude(test_list, anotherMultitude).toArray()));

        assertEquals(intersectionMultitude, test.intersectionMultitude(test_list, anotherMultitude),
                "Должен быть новый список элементов, которые не пересекаются с заданным массивом!");
    }

    @Test
    public void test_second()
    //Тест, где исключение это null массив в списке
    {
        test_list.add(el_null);
        test_list.add(el2);
        test_list.add(el_null);

        assertThrows(
                NullPointerException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.intersectionMultitude(test_list, anotherMultitude);
                }
        );
    }

    @Test
    public void test_third() {
        test_list.add(el1);
        test_list.add(el_null);
        test_list.add(el3);
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.intersectionMultitude(test_list, anotherNullMultitude);
                }
        );
    }

    @Test
    public void test_fourth() {
        test_list.add(el1);
        test_list.add(el_null);
        test_list.add(el3);
        assertThrows(
                NullPointerException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.intersectionMultitude(test_list_null, anotherNullMultitude);
                }
        );
    }

}
