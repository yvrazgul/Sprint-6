package com.example;

import org.example.Feline;
import org.example.Lion;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionNegativeTest {

    @Mock
    Feline feline;
    String sex;


    @Test
    public void lionSexExceptionTest () throws Exception{
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, sex));
        String actual = exception.getMessage();
        assertEquals( "Используйте допустимые значения пола животного - Самец или Самка", actual);
    }
}
