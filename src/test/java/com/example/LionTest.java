package com.example;

import org.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.example.Lion;
import java.util.List;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(Parameterized.class)

public class LionTest {
    private final String sex;
    private final String type;
    private final List food;
    private final boolean exMane;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;
    public LionTest(String sex, boolean exMane,String type, List food) {
        this.sex = sex;
        this.exMane = exMane;
        this.type = type;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", false, "Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Самка", true, "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
        Assert.assertEquals("Результат не совпадает с ожидаемым", 0, lion.getKittens());
    }

        @Test
          public void getFoodTest() throws Exception {
          Lion lion = new Lion(feline, sex);
          Mockito.when(feline.getFood(type)).thenReturn(food);
          Assert.assertEquals("Неподходящая еда", food, lion.getFood());
    }
}

