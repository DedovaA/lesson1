package ru.geekbrains.lesson1;

public class MyApp {
    public static void main(String[] args) {
        byte byteVal = 127;
        int intVal = 1270000;
        short shortVal = 10027;
        long longVal = 127000L;
        float floatVal = 127.01f;
        double doubleVal = 127.012;
        char charVal = '*';
        boolean booleanVal = true;

        System.out.println(sum(1.0f, 2.0f, 2.22f, 1.11f));
        System.out.println(method2(10,11));
        method3(-1);
        method4(3);
        method5("Asya");
        whichYear(100);
        whichYear(800);
        whichYear(2000);
        whichYear(2001);
        whichYear(2002);
        whichYear(2003);
        whichYear(2004);
    }
    static float sum (float a, float c, float b, float d) {
        return a * (b + (c / d));
    }

    static boolean method2 (int a, int b) {
        int c = a + b;
        return (c > 9 && c < 21);
    }

    static void method3 (int x) {
        if (x >= 0) System.out.println("positive");
        else System.out.println("negative");
    }

    static void method4 (int x) {
        System.out.println(x >= 0);
    }

    static void method5 (String name) {
        System.out.println("Hi, " + name + "!");
    }

    static void whichYear (int a) {
        if (a % 100 == 0 && a % 400 == 0)
            System.out.println("високосный");
        else if (a % 4 == 0 && a % 100 > 0)
            System.out.println("високосный");
        else if (a % 100 == 0)
            System.out.println("обычный");
        else
            System.out.println("обычный");
    }
}
