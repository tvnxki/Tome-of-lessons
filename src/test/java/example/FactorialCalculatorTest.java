package example;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new FactorialCalculator();
        System.out.println("Подготовка перед тестом");
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
        System.out.println("Очистка после теста");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Запуск тестов факториала");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Завершение тестов факториала");
    }

    @Test(description = "Тест факториала нуля")
    public void testFactorialOfZero() {
        long result = calculator.calculate(0);
        assertEquals(result, 1, "Факториал 0 должен быть 1");
    }
}
