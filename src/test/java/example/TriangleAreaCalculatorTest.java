package example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Тесты для вычисления площади треугольника")
class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    @DisplayName("Площадь прямоугольного треугольника (6-8-10)")
    void testRightTriangleArea() {
        double area = calculator.calculateByThreeSides(6, 8, 10);
        assertEquals(24.0, area, 0.01, "Площадь треугольника 6-8-10 должна быть 24");
    }

    @Test
    @DisplayName("Площадь равностороннего треугольника")
    void testEquilateralTriangleArea() {
        double area = calculator.calculateByThreeSides(5, 5, 5);
        double expected = (Math.sqrt(3) / 4) * 25;
        assertEquals(expected, area, 0.01);
    }


}