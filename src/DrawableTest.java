import java.util.List;
import java.util.ArrayList;
public class DrawableTest {
    public static void main(String[] args) {
        List<Drawable> drawable = new ArrayList<>();

        Circle circle1 = new Circle("red", 5.0);
        Circle circle2 = new Circle("blue", 3.0);
        drawable.add(circle1);
        drawable.add(circle2);

        Cube cube1 = new Cube("green", 4.0);
        Cube cube2 = new Cube("yellow", 2.0);
        drawable.add(cube1);
        drawable.add(cube2);

        double tArea = 0;
        double totalVolume = 0;

        double totalArea = 0, tVol = 0;
        for (var entry : drawable) {
            totalArea += ((Shape)entry).getArea();
            if (entry instanceof ThreeDShape)
                tVol  += ((ThreeDShape)entry).getVolume();
        }

        System.out.println("Total Area: " + totalArea);
        System.out.println("Total Volume: " + tVol);
    }
}
