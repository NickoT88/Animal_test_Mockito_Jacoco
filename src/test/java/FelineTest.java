import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test //проверка что Feline семейства Кошачьих
    public void getFamilyShouldReturnFelineFamily() {
        String family = "Кошачьи";
        assertEquals(family, feline.getFamily());
    }

    @Test //тест метода getKittens(), который возвращает 1 котенка
    public void getKittensShouldReturnOneKitten() {
        assertEquals(1, feline.getKittens());
    }

    @Test //тест 2 метода getKittens() с определенным кол-вом котят
    public void getKittensWithDifferentCount() {
        assertEquals(6, feline.getKittens(6));
    }

    @Test //тест метода eatMeat(), что он выводит нужный список еды для Feline
    public void eatMeatIsMeat() throws Exception {
        List<String> foodFofFeline = List.of("Животные", "Птицы", "Рыба");
        assertEquals(foodFofFeline, feline.eatMeat());
    }


}
