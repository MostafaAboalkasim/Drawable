public class Circle extends Shape{
    private double raduis;

    public Circle() {
        super();
        this.raduis = 0.0; // Default value
    }

    public Circle(String color, double radius) {
        super(color);
        this.raduis = Math.max(radius, 0.0);
    }

    public double getRaduis() {
        return raduis;
    }

    public void setRaduis(double raduis) {
        this.raduis = raduis;
    }

    @Override
    public String toString() {return ("This is a Circle with radius: " + raduis);}

    @Override
    public double getArea() {return Math.PI * raduis * raduis;}

    @Override
    public double getPerimeter() {return 2 * Math.PI * raduis;}

    @Override
    public String howToDraw() {
        return "Make a Circle"; //TODO: What can I put here ?
    }
}
