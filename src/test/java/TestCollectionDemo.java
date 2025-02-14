import org.example.CollectionDemo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCollectionDemo {
    List<String> test_list = new ArrayList<>();
    CollectionDemo test = new CollectionDemo();
    char test_char = 'I';
    char test_char_null = '\u0000';
    String test_str_1 = "Image";
    String test_str_2 = "Integer";
    String test_str_3 = "Apple";
    String test_str_null = null;
    StringBuilder str_input = new StringBuilder();

    @Test
    public void test_first()
    //Тест где все работает
    {
        test_list.add(test_str_1);
        test_list.add(test_str_2);
        test_list.add(test_str_3);

        for(String i: test_list)
        {
            if (i.charAt(0) == test_char)
                str_input.append(i);
        }

        assertEquals(str_input.toString(), test.amountString(test_list, test_char).toString(), "Должно быть выведено: ImageInteger");
    }
    @Test
    public void test_second()
    //Тест, где исключение это null строчки в списке
    {
        test_list.add(test_str_null);
        test_list.add(test_str_2);
        test_list.add(test_str_null);

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.amountString(test_list, test_char);
                }
        );
    }

    @Test
    public void test_third()
    {
        test_list.add(test_str_1);
        test_list.add(test_str_null);
        test_list.add(test_str_3);
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.amountString(test_list, test_char_null);
                }
        );
    }

}
