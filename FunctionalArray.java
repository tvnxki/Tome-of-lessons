class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

public class FunctionalArray {
    public static void checkArray(String[][] array)
            throws MyArraySizeException {
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть пустой");
        }

        if (array.length != 4) {
            throw new MyArraySizeException(
                    String.format("Нужно 4 строки, получено: %d", array.length)
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException(
                        String.format("Строка %d не должна быть пустой", i)
                );
            }
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("В строке %d нужно 4 элемента, получено: %d", i, array[i].length)
                );
            }
        }
        System.out.println("Обработка 4х4 массива");
    }

    public static int sumArrayElements(String[][] array)
            throws MyArraySizeException, MyArrayDataException {
        checkArray(array);
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Неправильные данные в ячейке [%d][%d]: '%s'", i, j, array[i][j])
                    );
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // в ячейке [3][3] лежит текст asd
        String[][] testArray1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "asd"}
        };
        try {
            int result = sumArrayElements(testArray1);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибочный размер массива: " + e.getMessage() + "\n");
        } catch (MyArrayDataException e) {
            System.out.println("Ошибочные данные в массиве: " + e.getMessage() + "\n");
        }

        String[][] smallArray = {{"1", "2"}, {"3", "4"}};

        try {
            System.out.println("Обращение к smallArray[5][0]");
            String value = smallArray[5][0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println(e.getMessage());
        }
    }
}