package ru.geekbrains.lesson9;

import org.jetbrains.annotations.NotNull;

public class lesson9 {
    public static void main(String[] args) {
        //Инициализируем квадратный массив 4х4
        String[][] strings = new String[4][4];
        //Инициализируем массив треугольный
        String[][] strings_ = createArray();
        initArray(strings);
        initArray(strings_);

        //один из элементов массива изменили
        strings[2][3] = "/";
        //пытаемся просуммировать массив
        try {
            System.out.println(sum(strings));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("%s в строке %d, столбце %d", e.getMessage(), e.getRow(), e.getCol());
        }
    }

    private static void initArray(String[][] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] = "1";
            }
        }
    }

    @NotNull
    private static String[][] createArray() {
        String[][] strings_ = new String[4][];
        for (int i = 0; i < 4; i++)
            strings_[i] = new String[i];
        return strings_;
    }

    static int sum(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        if (!isArraySizeValid(strings))
            throw new MyArraySizeException("Неверный размер массива.");
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка парсинга", i, j);
                }
            }
        }
        return sum;
    }

    static boolean isArraySizeValid(String[][] strings) {
        if (strings.length != 4) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != 4)
                return false;
        }
        return true;
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
