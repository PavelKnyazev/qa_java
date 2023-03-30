import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final boolean mane;
    private final String sex;

    public LionParameterizedTest(boolean mane, String sex) {
        this.mane = mane;
        this.sex = sex;
    }

    @Mock
    Predator predator;

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
     * Тест првоеряет создание объекта с мужским и женским полом
     *
     */
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex,predator);
        assertEquals(mane, lion.doesHaveMane());
    }

}
