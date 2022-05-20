package ru.geekbrains.lesson14;

public class Lesson14 {

    public static int[] task1 (int[] arr){
        int indexOfFour = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) indexOfFour = i;
        }
        if (indexOfFour == -1) throw new RuntimeException("Элемент со значением 4 не найден");
        int resultArrayLength = arr.length - indexOfFour - 1;
        int[] resultArray = new int[resultArrayLength];
        System.arraycopy(arr, ++indexOfFour, resultArray,0, resultArrayLength);
        return resultArray;
    }

    public static boolean task2 (int[] arr){
        int one = 0;
        int four = 0;
        for(int i: arr){
            if(i == 1) one = 1;
            if(i == 4) four = 1;
        }
        return (one + four) == 2;
    }

}
