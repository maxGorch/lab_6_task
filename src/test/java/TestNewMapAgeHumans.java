import org.example.Human;
import org.example.ListDemo;
import org.example.Student;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNewMapAgeHumans {
    ListDemo test = new ListDemo();
    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Human productH_4 = new Human("Гриша", "Сучков", "Кириллович", 20);

    Human productH_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Student productS_1 = new Student("Роман", "Гнусарев", "Викторович", 45, "ФЦТК");
    Student productS_2 = new Student("Петр", "Иванов", "Олегович", 25, "ФЦТК");


    Set<Human> setHuman = new HashSet<>();
    Map<Integer, List<Human>> test_mapHuman = new HashMap<>();

    @Test
    public void test_first_1Correct() {
        List<Human> test_listHumans25 = new ArrayList<>();

        setHuman.add(productH_3);//25
        setHuman.add(productH_1);//25
        setHuman.add(productS_2);//25


        test_listHumans25.add(productH_3);
        test_listHumans25.add(productH_1);
        test_listHumans25.add(productS_2);
        test_mapHuman.put(25, test_listHumans25);

        Integer keyMap;
        List <Human> valueMap;
        for (Map.Entry<Integer, List<Human>> entry : test_mapHuman.entrySet()) {
            keyMap = entry.getKey();
            valueMap = entry.getValue();
            System.out.println(keyMap);
            System.out.println(valueMap);

        }

        assertEquals(test_mapHuman, test.newMapAgeHumans(setHuman),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }

    @Test
    public void test_first_2Variable() {

        List<Human> test_listHumans25 = new ArrayList<>();
        List<Human> test_listHumans20 = new ArrayList<>();

        setHuman.add(productH_1);//25
        setHuman.add(productH_2);//20
        setHuman.add(productH_3);//25
        setHuman.add(productH_4);//20


        test_listHumans25.add(productH_3);
        test_listHumans25.add(productH_1);
        test_mapHuman.put(25, test_listHumans25);

        test_listHumans20.add(productH_2);
        test_listHumans20.add(productH_4);
        test_mapHuman.put(20, test_listHumans20);

        Integer keyMap;
        List <Human> valueMap;
        for (Map.Entry<Integer, List<Human>> entry : test_mapHuman.entrySet()) {
            keyMap = entry.getKey();
            valueMap = entry.getValue();
            System.out.println(keyMap);
            System.out.println(valueMap);

        }

        assertEquals(test_mapHuman, test.newMapAgeHumans(setHuman),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }

    @Test
    public void test_first_3Variable() {
        List<Human> test_listHumans25 = new ArrayList<>();
        List<Human> test_listHumans20 = new ArrayList<>();
        List<Human> test_listHumans45 = new ArrayList<>();

        setHuman.add(productH_1);//25
        setHuman.add(productH_2);//20
        setHuman.add(productS_1);//45


        test_listHumans25.add(productH_1);
        test_mapHuman.put(25, test_listHumans25);

        test_listHumans20.add(productH_2);
        test_mapHuman.put(20, test_listHumans20);

        test_listHumans45.add(productS_1);
        test_mapHuman.put(45, test_listHumans45);

        Integer keyMap;
        List <Human> valueMap;
        for (Map.Entry<Integer, List<Human>> entry : test_mapHuman.entrySet()) {
            keyMap = entry.getKey();
            valueMap = entry.getValue();
            System.out.println(keyMap);
            System.out.println(valueMap);

        }

        assertEquals(test_mapHuman, test.newMapAgeHumans(setHuman),
                "Результат — множество людей, идентификаторы которых содержатся во входном множестве.");

    }

    @Test
    public void test_first_IllegalArgumentExceptionIn() {
        setHuman.add(null);
        setHuman.add(productH_2);
        setHuman.add(null);

        assertThrows(NullPointerException.class, () ->
        {
            test.newMapAgeHumans(setHuman);
        }, "Мы должны получить исключение за счет null эл-ов в Map!");

    }
}
