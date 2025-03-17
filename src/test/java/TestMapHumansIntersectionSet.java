import org.example.Human;
import org.example.ListDemo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMapHumansIntersectionSet {
    ListDemo test = new ListDemo();
    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Human productH_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Map<Integer, Human> mapHuman = new HashMap<>();
    Set<Integer> anotherMultitude = new HashSet<>();
    @Test
    public void test_first_0Correct() {
        Set<Human> newSetHuman = new HashSet<>();

        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        anotherMultitude.add(123);
        anotherMultitude.add(456);


        assertEquals(newSetHuman, test.mapHumansIntersectionSet(mapHuman, anotherMultitude),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }
    @Test
    public void test_first_2Correct() {
        Set<Human> newSetHuman = new HashSet<>();

        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        anotherMultitude.add(12345);
        anotherMultitude.add(67890);

        newSetHuman.add(productH_1);
        newSetHuman.add(productH_2);

        assertEquals(newSetHuman, test.mapHumansIntersectionSet(mapHuman, anotherMultitude),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }
    @Test
    public void test_first_3Correct() {
        Set<Human> newSetHuman = new HashSet<>();

        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        anotherMultitude.add(12345);
        anotherMultitude.add(67890);
        anotherMultitude.add(111213);

        newSetHuman.add(productH_1);
        newSetHuman.add(productH_2);
        newSetHuman.add(productH_3);
        assertEquals(newSetHuman, test.mapHumansIntersectionSet(mapHuman, anotherMultitude),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }
    @Test
    public void test_first_NullPointerExceptionInMap () {
        mapHuman.put(null, null);
        mapHuman.put(null, productH_2);
        mapHuman.put(111213, null);

        anotherMultitude.add(12345);
        test.mapHumansIntersectionSet(mapHuman, anotherMultitude);

}
    @Test
    public void test_first_IllegalArgumentExceptionInSet1() {
        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        anotherMultitude.add(null);

        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansIntersectionSet(mapHuman, anotherMultitude);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }
    @Test
    public void test_first_IllegalArgumentExceptionInSet2() {
        mapHuman.put(12345, productH_1);
        mapHuman.put(67890, productH_2);
        mapHuman.put(111213, productH_3);

        anotherMultitude.add(12345);
        anotherMultitude.add(null);

        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansIntersectionSet(mapHuman, anotherMultitude);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }

}
