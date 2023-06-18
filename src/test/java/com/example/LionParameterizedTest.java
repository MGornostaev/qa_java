package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
                { "Дирижабль", false},
        };
    }

    @Test
    public void doesHaveManeShouldReturnBooleanDependsOnSex() {
        try {
            Lion lion = new Lion(sex);
            boolean actualResult = lion.doesHaveMane();
            assertEquals(result, actualResult);
        } catch (Exception exception) {
            // Если пришел эксепшн о неизвестном поле - считаем что гривы нет
            assertFalse(result);
        }
    }
}
