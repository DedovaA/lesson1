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
        }
        int attempt = 0;

        do {
            ++attempt;
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == number) {
                System.out.println("Поздравляем, вы угадали число!");
                break;
            } else {
                if (userInput>number) System.out.println("Ваше число больше");
                else System.out.println("Ваше число меньше");
                System.out.printf("У вас отсалось %d попыток \n", (3-attempt));
            }
        } while (attempt < 3);
        if (attempt == 3) System.out.println("Вы проиграли.");
        repeatGame();


    }
    private static void repeatGame(){
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int answer = scanner.nextInt();
        scanner.nextLine();
        switch (answer){
            case 1:
                game();
                break;
            case 0:
                return;
            default:
                System.out.println("Некорректный ввод. Повторите попытку.");
        }
    }

}
