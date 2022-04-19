package ru.geekbrains.lesson9;

public class lesson9 {
    public static void main(String[] args) {
        //Инициализируем массив
        String[][] strings = new String[4][4];
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                strings[i][j] = "1";
            }
        }
        //один из элементов массива изменили
        strings[2][3] = "*";
        //пытаемся просуммировать массив
        try {
            System.out.println(sum(strings));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.printf("%s в строке %d, столбце %d", e.getMessage(), e.getRow(), e.getCol());
        }
    }

    public static int sum (String[][] strings) throws MyArraySizeException, MyArrayDataException {
        if (strings.length != 4 || strings[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива.");
        }
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
