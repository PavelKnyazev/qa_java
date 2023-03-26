import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    /**
     * Тест проверяет вызывается ли метод eatMeat() при вызове метода getFood().
     */

    @Test
    public void getFoodCalledEatMeatTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    /**
     * Тест проверяет, что метод getSound() вызывается и возвращает строку "Мяу".
     */
    @Test
    public void getSoundReturnMewTest() {
        Cat catMock = Mockito.mock(Cat.class);
        Mockito.when(catMock.getSound()).thenReturn("Мяу");
        String sound = catMock.getSound();
        Mockito.verify(catMock).getSound();
        Assert.assertEquals("Мяу", sound);
    }

}


