package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class lesson3task1 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();
    public static void main(String[] args) {
        game();
    }

    private static void game() {
        int number = rand.nextInt(10);
        System.out.println("Угадайте число от 0 до 9 с трех попыток.\nВведите число.");
        if (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод. Повторите попытку.");
            scanner.nextLine();
        }
        int attempt = 0;
        do {
            ++attempt;
            if (scanner.nextInt() == number) {
                System.out.println("Поздравляем, вы угадали число!");
                return;
            } else {
                System.out.printf("У вас отсалось %d попыток \n", (3-attempt));
            }
        } while (attempt < 3);
        System.out.println("Вы не угадали число.");
    }
}
