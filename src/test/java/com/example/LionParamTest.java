package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final Boolean hasMane; // Исправлено: hasMane вместо gasMane

    public LionParamTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setParams() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        // Добавлена переменная feline
        Feline feline = new Feline(); // Инициализирована feline
        Lion lion = new Lion(feline, sex); // Передан feline в конструктор Lion

        assertEquals(hasMane, lion.doesHaveMane());
    }
}
