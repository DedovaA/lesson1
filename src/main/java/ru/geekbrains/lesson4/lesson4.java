package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {

    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = '0';
    static final char DOT_EMPTY = '*';
    static final int WIN_COUNT = 3; // Выиграшная комбинация

    static  final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    static char[][] field; //текущее состояние игрового поля
    static int fieldSizeX; //размерность поля
    static int fieldSizeY;

    /**
     * Инициалицация поля( объектов игры)
     */
    static void initialize() {
        fieldSizeX = 3;
        fieldSizeY = 3;

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeX; y++) {
                field[x][y] = DOT_EMPTY;
                }
        }
    }

    /**
     * Отрисовка поля
     */
    static void printField() {
        System.out.print("+");

        for (int i = 0; i < fieldSizeX*2 + 1; i++) {
            System.out.print((i % 2) == 0 ? "-" : i/2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i <=fieldSizeX*2 + 1 ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода человека
     */
    static void humanTurn(){
        int x, y;
        do{
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Обработка хода AI
     * TODO AI
     */
    static void aiTurn(){
        int x, y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, ячейка пустая DOT_EMPTY
     * @param x координата хода
     * @param y координата хода
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка,корректности ввода (координаты хода не должны превышать размерность массива)
     * @param x координата хода
     * @param y координата хода
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка на ничью (все поле заполнно фишками)
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if(isCellEmpty(x,y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка на победу
     * TODO переработать в ДЗ
     * @param
     * @return
     */
    static boolean checkWin(char c) {
        //порверка по трем горизонталям
        if(field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if(field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if(field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
        //по вертикали
        if(field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if(field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if(field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
        //диагональ
        if(field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if(field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    static boolean checkWinV2(char c){
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkWinDot(c, x, y, WIN_COUNT))
                    return true;
            }
        }
        return false;
    }

    static boolean checkWinDot(char c, int x, int y, int winCount){
        //TODO: Совершаем 4 проверки
        return true;
    }

    /**
     * Метод проверки состояния игры
     * @param dot фишка игрока
     * @param message победный слоган
     *
     *  true -     завершение игры
     *
     * @return состояние игры
     */
    static boolean gemChecks(char dot, String message){
        if (checkWin(dot)){
            System.out.println(message);
            return  true;
        }
        if (checkDraw()){
            System.out.println("ничья");
            return true;
        }
        //продолжим игру
        return false;
    }
 

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true){
                humanTurn();//обработка хода человека
                printField();
                if (gemChecks(DOT_HUMAN, "победа")){
                    break;
                }

                aiTurn();
                printField();
                if (gemChecks(DOT_AI, "победа ai")){
                    break;
                }
            }
            System.out.println("играем еще? (Y - да)");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }


    }
}
