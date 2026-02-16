package example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationTest {

    private ArithmeticOperations arithmetic;

    @BeforeMethod
    public void setUp() {
        arithmetic = new ArithmeticOperations();
    }

    @Test(description = "Тест сложения")
    public void testAddition() {
        assertEquals(arithmetic.add(2, 3), 5);
        assertEquals(arithmetic.add(2, -3), -1);
        assertEquals(arithmetic.add(0, 0), 0);
    }

    @Test(description = "Тест вычитания")
    public void testSubtraction() {
        assertEquals(arithmetic.subtract(2, 3), -1);
        assertEquals(arithmetic.subtract(2, -3), 5);
        assertEquals(arithmetic.subtract(5, 5), 0);
    }

    @Test(description = "Тест умножения")
    public void testMultiplication() {
        assertEquals(arithmetic.multiply(2, 3), 6);
        assertEquals(arithmetic.multiply(2, -3), -6);
        assertEquals(arithmetic.multiply(5, 0), 0);
    }

    @Test(description = "Тест деления")
    public void testDivision() {
        assertEquals(arithmetic.divide(5, 2), 2.5);
        assertEquals(arithmetic.divide(-5, 2), -2.5);
        assertEquals(arithmetic.divide(0, 5), 0.0);
    }

    @Test(description = "Тест деления на ноль",
            expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль невозможно")
    public void testDivisionByZero() {
        arithmetic.divide(5, 0);
    }
}
