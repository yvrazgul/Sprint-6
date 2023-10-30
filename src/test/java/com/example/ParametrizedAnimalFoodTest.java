package com.example;

import org.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedAnimalFoodTest {

    private final String typeOfAnimal;
    private final List result;


    public ParametrizedAnimalFoodTest(String typeOfAnimal, List result) {
        this.typeOfAnimal = typeOfAnimal;
        this.result = result;
    }
    @Parameterized.Parameters
    public static Object[][] foodParam() {

        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void getFoodTest() throws Exception {
        Animal testAnimal = new Animal();
        List foodResult = testAnimal.getFood(typeOfAnimal);
        Assert.assertEquals(result, foodResult);
    }
}
