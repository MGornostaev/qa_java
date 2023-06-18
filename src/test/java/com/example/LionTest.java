package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    Feline feline;

    @Test
    public void getKittensWithoutParamsShouldReturnOne(){
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);

        int expectedResult = 1;
        int actualResult = lion.getKittens();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();

        assertEquals(expectedResult, actualResult);
    }
}
