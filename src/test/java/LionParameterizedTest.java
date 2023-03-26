import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;




@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final boolean mane;
    private final String sex;

    public LionParameterizedTest(boolean mane, String sex) {
        this.mane = mane;
        this.sex = sex;
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Parameterized.Parameters
    public static Object[][] getParamData() {
        return new Object[][]{
                {true, "Самец"},
                {false, "Самка"},

        };
    }

    /**
     * Тест првоеряет возвращает ли метод doesHaveMane()
     * правильное значение в зависимости от пола
     *
     */

    @Test
    public void doesHaveManeTest() throws Exception {

        Lion lionMock = Mockito.mock(Lion.class);
        Mockito.when(lionMock.doesHaveMane()).thenReturn(mane);
        boolean actual = lionMock.doesHaveMane();
        Assert.assertEquals(mane, actual);
    }

    /**
     * Тест првоеряет создание объекта с мужским и женским полом
     *
     */
    @Test
    public void sexTest() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex,predatorMock);
        Assert.assertEquals(mane, lion.doesHaveMane());
    }

}
