package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundShouldReturnMeow(){
        Cat cat = new Cat(feline);

        String expectedResult = "Мяу";
        String actualResult = cat.getSound();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodShouldReturnFoodList() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult, actualResult);
    }
}
