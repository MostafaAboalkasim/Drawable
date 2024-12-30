class Cube extends ThreeDShape {
    private double side;

    public Cube() {
        super();
        this.side = 0.0; // Default Value
    }
    public Cube(String color, double side) {
        super(color);
        this.side = Math.max(0, side);
    }

    public double getSide() {return side;}

    public void setSide(double side) {this.side = side;}

    @Override
    public double getArea() {return 6 * side * side;}

    @Override
    public double getPerimeter() {return 12 * side;}

    @Override
    public double getVolume() {return side * side * side;}

    @Override
    public String toString() {return ("This is a Cube with side: " + side);}

    @Override
    public String howToDraw() {return "Draw a cube.";}
}
