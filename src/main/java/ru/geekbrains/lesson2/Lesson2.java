package ru.geekbrains.lesson2;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4(11);
//        task5();
//        System.out.println(task6(new int[]{2, 2, 2, 1, 2, 2, 10, 1})); //true
//        System.out.println(task6(new int[]{1, 1, 1, 2, 1})); //true
//        System.out.println(task6(new int[]{2, 2, 2, 1, 2, 2, 10, 2})); //false
        task7(new int[]{1, 2, 3}, 1);
        task7(new int[]{3, 5, 6, 1}, -2);
    }

    static void task1 () {
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        System.out.print(Arrays.toString(arr) + " ==> ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void task2 () {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void task3 () {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print(Arrays.toString(arr) + " ==> ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void task4 (int size){
        int[][] arr = new int[size][size];
        for (int y = 0, end = size; y < size; y++, end--) {
            for (int x = 0; x < size; x++) {
                if (y == x || x == end-1) arr[y][x] = 1;
                System.out.print(arr[y][x] + "  ");
            }
            System.out.println();
        }
    }

    static void task5 (){

        int[] arr = {1, 5, -3, 2, 11, 4, 0, 2, 4, 8, 9, -1};
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (min > arr [i + 1]) min = arr[i];
            if (max < arr [i + 1]) max = arr[i];
        }
        System.out.printf("min = %d, max = %d \n", min, max );
    }

    static boolean task6 (int[] arr){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int partOfArr = 0;
        for (int i : arr) {
            partOfArr += i;
            if (partOfArr == sum - partOfArr) return true;
        }
        return false;
    }

    static void task7 (int @NotNull [] arr, int n){
        int[] array = arr;

        n = (arr.length + n % arr.length) % arr.length;

        int temp;
        if (n > 0) {
            System.out.print("смещение всех элементов на " + n + " вправо " + Arrays.toString(array) + " ==> ");
            do {
                --n;
                for (int i = arr.length-1; i > 0; i--) {
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }
            } while (n != 0);
        } else {
            System.out.print("смещение всех элементов на " + n + " влево " + Arrays.toString(array) + " <== ");
            do {
                ++n;
                for (int i = 0; i < arr.length-1; i++) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]  = temp;
                }
            } while (n != 0);
        }
        System.out.println(Arrays.toString(array));

    }
}
