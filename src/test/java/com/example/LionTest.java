package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void getKittensWithoutArgumentReturnOneTest() throws Exception {
        lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int defaultKittensValue = 1;

        assertEquals(defaultKittensValue, lion.getKittens());
    }

    @Test
    public void lionConstructorWrongSexReturnErrorTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            lion = new Lion(feline, "Гермафродит");
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getFoodReturnPredatorFoodTest() throws Exception {
        lion = new Lion(feline, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        // Предполагается, что getFood принимает аргумент
        assertEquals(expectedFood, lion.getFood());
    }
}