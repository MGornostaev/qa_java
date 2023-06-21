package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean result;

    public LionParameterizedTest(String sex, boolean result) {
        this.sex = sex;
        this.result = result;
    }

    @Parameterized.Parameters(name = "Наличие гривы в зависимости от пола. Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void doesHaveManeShouldReturnBooleanDependsOnSex() throws Exception {
        Lion lion = new Lion(feline,sex);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(result, actualResult);
    }
}
