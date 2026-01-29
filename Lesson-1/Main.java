public class Main {
    public static void main(String[] args) {
        //1
        String printThreeWords = "Orange \nBanana \nApple";
        System.out.println(" 1.");
        System.out.println(printThreeWords);

        System.out.println("\n 2.");
        checkSumSign();

        System.out.println("\n 3.");
        printColor();

        System.out.println("\n 4.");
        compareNumbers();

        System.out.println("\n 5.");
        boolean result = checkSumRange(-3, -4);
        System.out.println(result);

        System.out.println("\n 6.");
        checkTrueOrFalseVariable();

        System.out.println("\n 7.");
        boolean resultSecond = negativeIs(-3);
        System.out.println(resultSecond);

        System.out.println("\n 8.");
        printStringMultipleTimes("123", 3);

        System.out.println("\n 9.");
        System.out.println(isVisokosnyYear(2028));

        System.out.println("\n 10.");
        printInvertingArray();
        System.out.println();

        System.out.println("\n 11.");
        fillingArray();

        System.out.println("\n 12.");
        doubledNumbersInArrOrNo();
        System.out.println();

        System.out.println("\n 13.");
        fillingMatrixArray();

        System.out.println("\n 14.");
        for (int num : fulfilArray(5, 9)) {
            System.out.print(num + " ");
        }

    }

    //2
    public static void checkSumSign() {
        int a = 2;
        int b = 4;
        int sum = a + b;

        if (sum >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");

    }

    //3
    public static void printColor() {

        int value = 101;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    public static void compareNumbers() {
        int a = 4, b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else if (a < b) {
            System.out.println("a < b");
        }
    }

    //5
    public static boolean checkSumRange(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //6
    public static void checkTrueOrFalseVariable() {
        int a = -1;
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //7
    public static boolean negativeIs(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //8
    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    //9
    public static boolean isVisokosnyYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //10
    public static void printInvertingArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
            System.out.print(array[i] + " ");
        }
    }

    //11
    public static void fillingArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }

        }
    }

    //12
    public static void doubledNumbersInArrOrNo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    //13
    public static void fillingMatrixArray() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    //14
    public static int[] fulfilArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

}








