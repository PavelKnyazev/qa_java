import com.example.*;
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
    Predator predator;

    /**
     * Тест проверяет выбросится ли исключение если попытаться создать объект неизвестного пола.
     */
    @Test(expected = Exception.class)
    public void doesHaveManeThrowExceptionTest() throws Exception {
        Lion lion = new Lion("no sex",predator);
    }

    /**
     * Тест проверяет getKittens().
     */
    @Test
    public void getKittensTest() throws Exception {

        Lion lion = new Lion("Самец",predator);
        Mockito.when(predator.getKittens()).thenReturn(3);
        Assert.assertEquals(3, lion.getKittens());
        Mockito.verify(predator).getKittens();
    }

    /**
     * Тест проверяет вызывается ли метод getFood() без аргументов и вызывает ли он метод getFood() c аргументом "Хищник"
     */
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец",predator);
        Lion spyLion = Mockito.spy(lion);
        List<String> actual = spyLion.getFood();
        Mockito.verify(spyLion).getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected,actual);
    }

}
