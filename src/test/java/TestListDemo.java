import org.example.Human;
import org.example.Student;
import org.example.ListDemo;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestListDemo
//TODO: Результат — список однофамильцев заданного человека
// среди людей из входного списка.
{
    List<Human> test_list = new ArrayList<>();
    ListDemo test = new ListDemo();
    Human productH_1 = new Human("Иван", "Иванов", "Иваныч", 25);
    Human productH_2 = new Human("Петр", "Иванов", "Олегович", 20);
    Human productH_3 = new Human("Василий", "Грекович", "Кириллович", 25);

    Student productS_1 = new Student("Василий", "Грекович", "Кириллович", 25, "ФЦТК");
    Student productS_2 = new Student("Петр", "Иванов", "Олегович", 30, "ФЦТК");
    Student productS_3 = new Student("Роман", "Гнусарев", "Викторович", 25, "ФЦТК");

    Human productH_another = new Human("Игорь", "Иванов", "Петрович", 25);
    Human productH_another_empty = new Human("Руслан", "", "Максимович", 16);
    List<Human> nameSake = new ArrayList<>();
    Set<Human> maxAge = new HashSet<>();
    Map<Integer, Human> mapHuman = new HashMap<>();
    Set<Integer> anotherMultitude = new HashSet<>();


    @Test
    public void getNamesake_test_first_allGood()
    // Тест, который проверяет работу метода getNamesake
    //Тест где все работает
    {
        test_list.add(productH_1);
        test_list.add(productH_2);
        test_list.add(productH_3);

        for (Human i : test_list) {
            if (i.getSecond_name().equals(productH_another.getSecond_name())) {
                nameSake.add(i);
            }
        }
        assertEquals(nameSake, test.getNamesake(test_list, productH_another), "Должен получится список однофамильцев");
    }

    @Test
    public void getNamesake_test_second_IllegalArgumentException()
    //Тест, где выбрасывается исключение связанное с аргументами
    {
        test_list.add(null);
        test_list.add(productH_2);
        test_list.add(null);

        assertThrows(IllegalArgumentException.class, () ->
        {
            test.getNamesake(test_list, productH_another);
            test.getNamesake(test_list, null);
            test.getNamesake(test_list, productH_another_empty);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }

    @Test
    public void copyListHuman_test_first_allGood()
    //Тест где все хорошо
    {
        test_list.add(productH_1);
        test_list.add(productH_2);
        test_list.add(productH_3);
        test_list.add(productH_another);
        List<Human> copy_list = test.copyListHuman(test_list, productH_another);

        List<Human> forCopy_list = new ArrayList<>();
        forCopy_list.add(productH_1);
        forCopy_list.add(productH_2);
        forCopy_list.add(productH_3);

        assertEquals(copy_list, forCopy_list);
    }

    @Test
    public void copyListHuman_test_first_IllegalArgumentException()
    //Тест, где выбрасывается исключение связанное с аргументами
    {
        test_list.add(null);
        test_list.add(productH_2);
        test_list.add(null);
        test_list.add(productH_another);

        assertThrows(IllegalArgumentException.class, () ->
        {
            test.copyListHuman(test_list, productH_another);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }

    @Test
    public void studentMaxAge_test_first_allGood() {
        test_list.add(productH_1);
        test_list.add(productS_1);
        test_list.add(productS_2);
        test_list.add(productS_3);

        int max = test_list.getFirst().getAge();

        for (Human i : test_list)
            if (i.getAge() > max) {
                max = i.getAge();
            }

        for (Human j : test_list) {
            if (j.getAge() == max) {
                maxAge.add(new Human(
                        j.getFirst_name(),
                        j.getSecond_name(),
                        j.getLast_name(),
                        j.getAge()));
            }
        }
        System.out.println("Для studentMaxAge_test_first_allGood:");
        System.out.println("Expected: " + Arrays.deepToString(maxAge.toArray()));
        System.out.println("Actual: " + Arrays.deepToString(test.studentMaxAge(test_list).toArray()));

        assertEquals(maxAge, test.studentMaxAge(test_list),
                "Должно новое множество из входного списка с максимальным возрастом!");
    }

    @Test
    public void studentMaxAge_test_first_IllegalArgumentException() {
        test_list.add(null);
        test_list.add(productS_2);
        test_list.add(null);

        assertThrows(NullPointerException.class, () ->
        {
            test.studentMaxAge(test_list);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }

    @Test
    public void mapHumansIntersectionSet_test_first_2Correct() {
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
    public void mapHumansIntersectionSet_test_first_NullPointerExceptionInMap () {
        mapHuman.put(null, null);
        mapHuman.put(null, productH_2);
        mapHuman.put(111213, null);

        anotherMultitude.add(12345);

        assertThrows(NullPointerException.class, () ->
        {
            test.mapHumansIntersectionSet(mapHuman, anotherMultitude);
        }, "Мы должны получить исключение за счет null эл-ов в списке!");
    }
    @Test
    public void mapHumansIntersectionSet_test_first_IllegalArgumentExceptionInSet1() {
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
    public void mapHumansIntersectionSet_test_first_IllegalArgumentExceptionInSet2() {
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
