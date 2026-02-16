package example;

public class TriangleAreaCalculator {

    public double calculateByThreeSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть положительными");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }

        double semiPerimeter = (a + b + c) / 2;
        double area = Math.sqrt(semiPerimeter *
                (semiPerimeter - a) *
                (semiPerimeter - b) *
                (semiPerimeter - c));
        return Math.round(area * 100.0) / 100.0;
    }

    public double calculateByBaseAndHeight(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными");
        }
        double area = (base * height) / 2;
        return Math.round(area * 100.0) / 100.0;
    }
}