public class Cube extends Shape3D {
    private String name = "cube";
    private double side;

    public Cube (double side) {
        this.side = side;
    }

    // ShapeTest case 10: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 11, 12: 2pts
    public double getArea() {
        return 6 * Math.pow(side, 2);
    }

    // ShapeTest cases 13, 14: 2pts
    public double getVolume() {
        return Math.pow(side, 3);
    }
}
