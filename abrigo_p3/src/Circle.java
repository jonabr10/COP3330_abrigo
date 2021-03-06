public class Circle extends Shape2D {
    private String name = "circle";
    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    // ShapeTest case 7: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 8, 9: 2pts
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
