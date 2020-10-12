public class Triangle extends Shape {
    private String name = "triangle";
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // ShapeTest case 4: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 5, 6: 1pt
    public double getArea() {
        return (0.5 * base * height);
    }
}
