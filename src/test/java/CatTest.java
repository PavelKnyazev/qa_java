import com.example.Cat;
import com.example.Feline;
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
     * Тест проверяет метод getSound()
     */
    @Test
    public void getSoundReturnMewTest() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

}


