import com.example.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String animalKind;
    private final List<String> expectedList;
    Animal animal;

    public AnimalParamTest(String animalKind,List<String> expectedList){
        this.animalKind=animalKind;
        this.expectedList=expectedList;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Травоядное", List.of("Трава","Различные растения")},
                {"Хищник", List.of("Животные","Птицы","Рыба")},
                {"Нечто", List.of("")},
        };
    }
    @Before
    public void initAnimal(){
        animal = new Animal();
    }

    @Test //тест ловит недействительный пол
    public void getFoodParameterized() {
        try{
            List <String> actualList = animal.getFood(animalKind);
            Assert.assertEquals(expectedList,actualList);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Test //тест метода getFamily(), что он выводит нужный String
    public void getFamilyReturnsLongString() {
        String actual= animal.getFamily();
        String expected="Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expected,actual);

    }
}