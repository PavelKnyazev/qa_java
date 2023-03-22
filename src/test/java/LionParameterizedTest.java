import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.assertEquals;

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


    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][]{
                {true, "Самец"},
                {false, "Самка"},

        };
    }

    /**
     * Тест првоеряет создание объекта с мужским и женским полом ,а так же возвращает ли метод doesHaveMane()
     * правильное значение в зависимости от пола
     *
     */

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex);
        Lion spyLion = Mockito.spy(lion);
        boolean actual = spyLion.doesHaveMane();
        Mockito.verify(spyLion).doesHaveMane();
        assertEquals(mane, actual);
    }

}
