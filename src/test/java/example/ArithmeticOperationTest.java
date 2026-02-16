package example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для арифметических операций")
class ArithmeticOperationsTest {

    private ArithmeticOperations arithmetic;

    @BeforeEach
    void setUp() {
        arithmetic = new ArithmeticOperations();
    }

    @Test
    @DisplayName("Тест сложения")
    void testAddition() {
        assertEquals(5, arithmetic.add(2, 3));
        assertEquals(-1, arithmetic.add(2, -3));
        assertEquals(0, arithmetic.add(0, 0));
    }

    @Test
    @DisplayName("Тест вычитания")
    void testSubtraction() {
        assertEquals(-1, arithmetic.subtract(2, 3));
        assertEquals(5, arithmetic.subtract(2, -3));
        assertEquals(0, arithmetic.subtract(5, 5));
    }

    @Test
    @DisplayName("Тест умножения")
    void testMultiplication() {
        assertEquals(6, arithmetic.multiply(2, 3));
        assertEquals(-6, arithmetic.multiply(2, -3));
        assertEquals(0, arithmetic.multiply(5, 0));
    }

    @Test
    @DisplayName("Тест деления")
    void testDivision() {
        assertEquals(2.5, arithmetic.divide(5, 2));
        assertEquals(-2.5, arithmetic.divide(-5, 2));
        assertEquals(0, arithmetic.divide(0, 5));
    }

    @Test
    @DisplayName("Тест деления на ноль")
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> arithmetic.divide(5, 0));
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }
}