package example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test(description = "Площадь прямоугольного треугольника (3-4-5)")
    public void testRightTriangleArea() {
        double area = calculator.calculateByThreeSides(3, 4, 5);
        assertEquals(area, 6.0, 0.01, "Площадь треугольника 3-4-5 должна быть 6");
    }

    @Test(description = "Площадь равностороннего треугольника")
    public void testEquilateralTriangleArea() {
        double area = calculator.calculateByThreeSides(5, 5, 5);
        double expected = (Math.sqrt(3) / 4) * 25;
        assertEquals(area, expected, 0.01);
    }
}
