public class Square extends Shape {
    private String name = "square";
    private double side;

    public Square (double side) {
        this.side = side;
    }

    // ShapeTest case 1: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest case 2: 1pt
    public double getArea() {
        return Math.pow(side, 2);
    }
}
