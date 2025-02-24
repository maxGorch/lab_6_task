import org.example.CollectionDemo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestIntersectionMultitude {
    CollectionDemo test = new CollectionDemo();
    List<int[]> test_list = new ArrayList<>();
    List<int[]> test_list_null = null;
    int[] el1 = {1, 2, 3};
    int[] el2 = {4, 5, 6, 7};
    int[] el3 = {8, 9};
    int[] el_null = null;
    int[] anotherMultitude = {2, 8};
    int[] anotherNullMultitude = null;

    @Test
    public void test_first() {
        // Тест, где всё работает
        test_list.add(el1);
        test_list.add(el2);
        test_list.add(el3);

        List<int[]> intersectionMultitude = new ArrayList<>();

        for (int[] el : test_list) {
            boolean flag = true;
            for (int i : anotherMultitude) {
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
