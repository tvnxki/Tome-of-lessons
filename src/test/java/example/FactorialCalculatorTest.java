package example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {
    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FactorialCalculator();
        System.out.println("BeforeEach test(prepare)");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("AfterEach test(clearing)");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll test(run test)");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll Closing test");
    }

    @Test
    @DisplayName("Тест факториала нуля")
    void testFactorialOfZero() {
        long result = calculator.calculate(0);
        assertEquals(1, result, "Факториал 0 должен быть 1");
    }

    @Test
    @DisplayName("Тест факториала единицы")
    void testFactorialOfOne() {
        long result = calculator.calculate(1);
        assertEquals(1, result, "Факториал 1 должен быть 1");
    }
}
