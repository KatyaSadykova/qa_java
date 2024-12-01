package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
    public void getKittensWithoutArgumentReturnOne() throws Exception {
        lion = new Lion(feline, "Самка");
        int defaultKittensValue = 1;

        assertEquals(defaultKittensValue, lion.getKittens());
    }

    @Test
    public void lionConstructorWrongSexReturnError() {
        Exception exception = assertThrows(Exception.class, () -> lion = new Lion(feline, "Гермафродит"));

        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getFoodReturnPredatorFood() throws Exception {
        lion = new Lion(feline, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");


        // Предполагается, что getFood принимает аргумент
        assertEquals(expectedFood, lion.getFood());
    }
}