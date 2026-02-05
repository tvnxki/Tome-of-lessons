interface Shape {
    double calculateArea();
    String getFillColor();
    String getBorderColor();


    default double calculatePerimeter() {
        return 0.0;
    }

    default void printInfo() {
        System.out.println("Площадь: " + formatWithPoint(calculateArea()) +
                ", Периметр: " + formatWithPoint(calculatePerimeter()) +
                ", Цвет фона: " + getFillColor() +
                ", Цвет границ: " + getBorderColor());
    }

    default String formatWithPoint(double number) {
        return String.format("%.2f", number);
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void printInfo() {
        System.out.print("Круг (радиус " + radius + "): ");
        Shape.super.printInfo();
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void printInfo() {
        System.out.print("Прямоугольник (" + width + "x" + height + "): ");
        Shape.super.printInfo();
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void printInfo() {
        System.out.print("Треугольник (" + sideA + ", " + sideB + ", " + sideC + "): ");
        Shape.super.printInfo();
    }
}

public class Geomethry {
    public static void main(String[] args) {
        Circle circle = new Circle(4.0, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(8.0, 12.0, "Синий", "Белый");
        Triangle triangle = new Triangle(6.0, 7.0, 8.0, "Зеленый", "Желтый");

        System.out.println("Информация о фигурах");
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

        System.out.println("\nПодробнее о фигурах:");

        System.out.println("Круг:");
        System.out.println("  Площадь: " + String.format("%.2f", circle.calculateArea()));
        System.out.println("  Периметр: " + String.format("%.2f", circle.calculatePerimeter()));
        System.out.println("  Цвет фона: " + circle.getFillColor());
        System.out.println("  Цвет границ: " + circle.getBorderColor());

        System.out.println("\nПрямоугольник:");
        System.out.println("  Площадь: " + String.format("%.2f", rectangle.calculateArea()));
        System.out.println("  Периметр: " + String.format("%.2f", rectangle.calculatePerimeter()));
        System.out.println("  Цвет фона: " + rectangle.getFillColor());
        System.out.println("  Цвет границ: " + rectangle.getBorderColor());

        System.out.println("\nТреугольник:");
        System.out.println("  Площадь: " + String.format("%.2f", triangle.calculateArea()));
        System.out.println("  Периметр: " + String.format("%.2f", triangle.calculatePerimeter()));
        System.out.println("  Цвет фона: " + triangle.getFillColor());
        System.out.println("  Цвет границ: " + triangle.getBorderColor());
    }
}