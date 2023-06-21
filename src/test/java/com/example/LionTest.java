package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Spy
    Feline feline;

    @Test
    public void getKittensWithoutParamsShouldReturnOne() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);

        int expectedResult = 1;
        int actualResult = lion.getKittens();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        ArrayList<String> expectedResult = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeWithUnknownSexShouldThrowException() {
        int exceptionCounter = 0;
        try {
            Lion lion = new Lion(feline, "Дирижабль");
            lion.doesHaveMane();
        } catch (Exception exception) {
            exceptionCounter++;
        }
        assertEquals(1,exceptionCounter);
    }
}
