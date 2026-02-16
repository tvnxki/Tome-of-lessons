package example;

public class NumberComparator {

    public int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
    public String compareAsString(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }

    public boolean isGreaterThan(int a, int b) {
        return a > b;
    }

    public boolean isLessThan(int a, int b) {
        return a < b;
    }

    public boolean isEqual(int a, int b) {
        return a == b;
    }
}