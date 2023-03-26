import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    /**
     * Тест проверяет, вызывается ли метод getFood() с аргументом Хищник при вызове метода eatMeat()
     *
     * @throws Exception
     */
    @Test
    public void eatMeatTest() throws Exception {

        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    /**
     * Тест проверяет вызывается ли getFamily() и возвращает ли он "Кошачьи"
     */
    @Test
    public void getFamilyTest() {
        Feline feelineMock = Mockito.mock(Feline.class);
        Mockito.when(feelineMock.getFamily()).thenReturn("Кошачьи");
        String actual = feelineMock.getFamily();
        Mockito.verify(feelineMock).getFamily();
        Assert.assertEquals("Кошачьи", actual);
    }

    /**
     * Тест проверяет что метод getKittens() с параметром вызывается и возвращает переданный в параметры аргумент.
     */
    @Test
    public void getKittensArgumentTest() {
        Feline feelineMock = Mockito.mock(Feline.class);
        int argument = 1;
        Mockito.when(feelineMock.getKittens(argument)).thenReturn(argument);
        int actualy = feelineMock.getKittens(argument);
        Mockito.verify(feelineMock).getKittens(Mockito.anyInt());
        Assert.assertEquals(argument, actualy);
    }

    /**
     * Тест проверяет что метод getKittens() без параметра вызывается и вызывает getKittens() с параметром.
     */
    @Test
    public void getKittensTestNoArgumentTest() {
        feline.getKittens();
        Mockito.verify(feline).getKittens();
        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }
}
