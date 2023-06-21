package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    int kittensNumber = 42;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> actualResult = feline.eatMeat();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamilyShouldReturnFeline() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensWithoutParamsShouldReturnOne() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensWithParamsShouldReturnGivenNumber() {
        int actualResult = feline.getKittens(kittensNumber);

        assertEquals(kittensNumber, actualResult);
    }
}