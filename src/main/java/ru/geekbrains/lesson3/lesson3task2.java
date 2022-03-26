package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lesson3task2 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int i = random.nextInt(words.length);
        String word = words[i];

        Scanner scanner = new Scanner(System.in);
        String attempt;
        char[] hint = "###############".toCharArray();


        System.out.printf("Угадайте слово %s\n", words[i]);

        do{
            attempt = scanner.nextLine();
            if (!attempt.equalsIgnoreCase(word)) {
                for (int k = 0; k < word.toCharArray().length; k++) {
                    if(attempt.charAt(k) == word.charAt(k))
                    hint[k] = attempt.charAt(k);
                }
                System.out.println(hint);
            }
        } while (!word.equalsIgnoreCase(attempt));
        System.out.printf("Поздравляем, вы угадали слово %s!\n", word);
    }
}
