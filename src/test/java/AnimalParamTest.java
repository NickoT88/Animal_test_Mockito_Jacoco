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
    private final String expectedExceptionMessage;
    Animal animal;

    public AnimalParamTest(String animalKind,List<String> expectedList,String expectedExceptionMessage){
        this.animalKind=animalKind;
        this.expectedList=expectedList;
        this.expectedExceptionMessage=expectedExceptionMessage;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {"Травоядное", List.of("Трава","Различные растения"),""},
                {"Хищник", List.of("Животные","Птицы","Рыба"),""},
                {"Неизвестный вид животного", List.of(""),"Неизвестный вид животного, используйте значение Травоядное или Хищник"},
        };
    }
    @Before
    public void initAnimal(){
        animal = new Animal();
    }

    @Test //тест ловит недействительный пол
    public void getFoodParameterized() {
        String actualExceptionMessage="";
        try{
            List <String> actualList = animal.getFood(animalKind);
            Assert.assertEquals(expectedList,actualList);
        } catch (Exception exception){
            actualExceptionMessage=exception.getMessage();
            Assert.assertEquals(expectedExceptionMessage,actualExceptionMessage);
        }
    }

    @Test //тест метода getFamily(), что он выводит нужный String
    public void getFamilyReturnsLongString() {
        String actual= animal.getFamily();
        String expected="Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expected,actual);

    }
}