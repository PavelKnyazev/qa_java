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
        String actual = feline.getFamily();
        Mockito.verify(feline).getFamily();
        Assert.assertEquals("Кошачьи", actual);
    }


    /**
     * Тест проверяет что метод getKittens() с параметром вызывается и возвращает переданный в параметры аргумент.
     */
    @Test
    public void getKittensArgumentTest() {
        int argument = 1;
        int actualy = feline.getKittens(argument);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        Assert.assertEquals(argument, actualy);
    }


    /**
     * Тест проверяет что метод getKittens() без параметра вызывается и вызывает getKittens() с параметром.
     */
    @Test
    public void getKittensTestNoArgumentTest(){
        feline.getKittens1();
        Mockito.verify(feline).getKittens1();
        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }
}
