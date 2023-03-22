import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;

    /**
     * Тест проверяет выбросится ли исключение если попытаться создать объект неизвестного пола.
     */
    @Test
    public void doesHaveManeThrowExceptionTest() {
        try {
            Lion lion = new Lion("no sex");
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    /**
     * Тест проверяет вызывается ли метод getKittens1() при вызове getKittens().
     */
    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens1();

    }

    /**
     * Тест проверяет вызывается ли метод getFood() без аргументов и вызывает ли он метод getFood() c аргументом "Хищник"
     */
    @Test
    public void GetFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        Lion spyLion = Mockito.spy(lion);
        List<String> actual = spyLion.getFood();
        Mockito.verify(spyLion).getFood();
        Mockito.verify(spyLion).getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected,actual);
    }

}
