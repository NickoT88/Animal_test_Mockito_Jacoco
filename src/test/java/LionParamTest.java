import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    @Mock
    private Feline feline;
    private final String sex;
    private final boolean hasMane;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[] setValues() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test //тест ловит недействительный пол
    public void doesHaveManeInvalidAnimal()  {
        String actualExeptionMessage = "";
        try {
            Lion lion = new Lion("Неизвестный науке пол",feline);
            lion.doesHaveMane();
        } catch (Exception exeption) {
            actualExeptionMessage = exeption.getMessage();
            String expectedExeptionMessage = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedExeptionMessage, actualExeptionMessage);
        }

    }

    @Test //тест наличия/отсутствия гривы
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test //тест вызова метода getKittens() один раз
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test //тест вызова метода getFood() один раз с любым аргументом типа String
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
    }
}
