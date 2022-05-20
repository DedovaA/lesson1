package ru.geekbrains.lesson14;

import org.junit.Assert;
import org.junit.Test;

public class Lesson14Test {
    /** Tests for task1*/
    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeException (){
        Lesson14.task1(new int[]{1,2,2,3,1,7});
    }

    @Test
    public void shouldReturnTwoLastElements (){
        Assert.assertArrayEquals(Lesson14.task1(new int[]{1,4,2,4,4,2,3,4,1,7}), new int[]{1,7});
    }

    @Test
    public void shouldReturnFourLastElements (){
        Assert.assertArrayEquals(Lesson14.task1(new int[]{1,4,2,4,4,2,3,1,7}), new int[]{2,3,1,7});
    }

    @Test
    public void shouldReturnEmptyArray (){
        Assert.assertArrayEquals(Lesson14.task1(new int[]{1,4,2,4,4,2,3,1,7,4}), new int[]{});
    }

    /** Tests for task2*/

    @Test
    public void shouldReturnTrue () {
        Assert.assertTrue(Lesson14.task2(new int[]{1,1,1,4,4,1,4,4}));
        Assert.assertTrue(Lesson14.task2(new int[]{1,4}));
        Assert.assertTrue(Lesson14.task2(new int[]{1,2,4,3}));
    }

    @Test
    public void shouldReturnFalse () {
        Assert.assertFalse(Lesson14.task2(new int[]{1,1,1,1,1,1}));
        Assert.assertFalse(Lesson14.task2(new int[]{4,4,4,4}));
        Assert.assertFalse(Lesson14.task2(new int[]{}));
    }

}
