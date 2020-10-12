public class Pyramid extends Shape3D{
    private String name = "pyramid";
    private double length;
    private double width;
    private double height;

    public Pyramid (double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // ShapeTest case 15: 1pt
    public String getName() {
        return name;
    }

    // ShapeTest cases 16, 17: 2pts
    public double getArea() {
        double a = length * width;
        double b = length * ( Math.sqrt( Math.pow(width/2, 2) + Math.pow(height, 2) ) );
        double c = width * ( Math.sqrt( Math.pow(length/2, 2) + Math.pow(height, 2) ) );

        return a + b + c;
    }

    // ShapeTest cases 18, 19: 2pts
    public double getVolume() {
        return (length * width * height) / 3;
    }
}
