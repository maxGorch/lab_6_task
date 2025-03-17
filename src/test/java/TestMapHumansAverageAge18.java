import org.example.Human;
import org.example.Student;
import org.example.ListDemo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMapHumansAverageAge18 {
    ListDemo test = new ListDemo();

    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 16);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 14);
    Human productH_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Student productS_1 = new Student("Василий", "Грекович", "Кириллович", 19, "ФЦТК");
    Student productS_2 = new Student("Петр", "Иванов", "Олегович", 30, "ФЦТК");
    Student productS_3 = new Student("Роман", "Гнусарев", "Викторович", 17, "ФЦТК");

    Map<Integer, Human> test_Map = new HashMap<>();
    Map<Integer, Human> test_MapNull = null;
    List<Integer> required_Map = new ArrayList<>();


    @Test
    public void test_0Correct() {
        test_Map.put(1, productH_1);//16 лет
        test_Map.put(2, productH_2);//16 лет
        test_Map.put(3, productS_3);//17 лет

        assertEquals(required_Map, test.mapHumansAverageAge18(test_Map));

    }
    @Test
    public void test_2Correct() {
        test_Map.put(1, productH_1);//16 лет
        test_Map.put(3, productH_3);//25 лет
        test_Map.put(2, productS_1);//19 лет

        required_Map.add(2);//19 лет
        required_Map.add(3);//25 лет

        assertEquals(required_Map, test.mapHumansAverageAge18(test_Map));

    }

    @Test
    public void test_3Correct() {
        test_Map.put(1, productS_1);//19 лет
        test_Map.put(2, productS_2);//30 лет
        test_Map.put(3, productH_3);//25 лет

        required_Map.add(1);//19 лет
        required_Map.add(2);//30 лет
        required_Map.add(3);//25 лет

        assertEquals(required_Map, test.mapHumansAverageAge18(test_Map));

    }

    @Test
    public void test_NullPointerException_MapID() {
        test_Map.put(null, productS_1);
        test_Map.put(2, productS_2);
        test_Map.put(null, productS_3);

        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansAverageAge18(test_Map);
        }, "Мы должны получить исключение за счет null эл-ов в Map (ID)!");

    }

    @Test
    public void test_NullPointerException_MapValue() {
        test_Map.put(1, null);
        test_Map.put(2, productS_2);
        test_Map.put(3, null);

        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansAverageAge18(test_Map);
        }, "Мы должны получить исключение за счет null эл-ов в Map (Value)!");

    }

    @Test
    public void test_NullPointerException_MapNull() {
        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansAverageAge18(test_MapNull);
        }, "Мы должны получить исключение что Map = null!");

    }

}
