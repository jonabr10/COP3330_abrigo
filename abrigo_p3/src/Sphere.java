public class Sphere extends Shape3D {
    private String name = "sphere";
    private double radius;

    public Sphere (double radius) {
        this.radius = radius;
    }

    // ShapeTest case 20: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 21, 22: 2pts
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // ShapeTest cases 23, 24: 2pts
    public double getVolume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}
