import org.example.Human;
import org.example.ListDemo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNewMapHumansWithAge {
    ListDemo test = new ListDemo();
    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Human productH_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Map<Integer, Human> mapHuman = new HashMap<>();
    Map<Integer, Integer> test_mapHuman = new HashMap<>();

    //    @Test
//    public void test_first_0Correct() {
//        Set<Human> newSetHuman = new HashSet<>();
//
//        mapHuman.put(12345, productH_1);
//        mapHuman.put(67890, productH_2);
//        mapHuman.put(111213, productH_3);
//
//        test_mapHuman.put(12345, productH_1.getAge());
//        test_mapHuman.put(67890, productH_2.getAge());
//        test_mapHuman.put(111213, productH_3.getAge());
//
//        assertEquals(test_mapHuman, test.newMapHumansWithAge(mapHuman),
//                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");
//
//    }
//    @Test
//    public void test_first_2Correct() {
//        Set<Human> newSetHuman = new HashSet<>();
//
//        mapHuman.put(12345, productH_1);
//        mapHuman.put(67890, productH_2);
//        mapHuman.put(111213, productH_3);
//
//        test_mapHuman.put(12345, productH_1.getAge());
//        test_mapHuman.put(67890, productH_2.getAge());
//
//        newSetHuman.add(productH_1);
//        newSetHuman.add(productH_2);
//
//        assertEquals(newSetHuman, test.newMapHumansWithAge(mapHuman),
//                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");
//
//    }
    @Test
    public void test_first_Correct() {

        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        test_mapHuman.put(12345, productH_1.getAge());
        test_mapHuman.put(67890, productH_2.getAge());
        test_mapHuman.put(111213, productH_3.getAge());

        assertEquals(test_mapHuman, test.newMapHumansWithAge(mapHuman),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }

    @Test
    public void test_first_IllegalArgumentExceptionIn() {
        mapHuman.put(null, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(null, productH_3);

        assertThrows(NullPointerException.class, () ->
        {
            test.newMapHumansWithAge(mapHuman);
        }, "Мы должны получить исключение за счет null эл-ов в Map!");

    }

    @Test
    public void test_first_IllegalArgumentExceptionInSet2() {
        mapHuman.put(12345, null);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, null);

        assertThrows(NullPointerException.class, () ->
        {
            test.newMapHumansWithAge(mapHuman);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }
}
