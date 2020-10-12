public class Square extends Shape2D {
    private String name = "square";
    private double side;

    public Square (double side) {
        this.side = side;
    }

    // ShapeTest case 1: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 2, 3: 1pt
    public double getArea() {
        return Math.pow(side, 2);
    }
}
