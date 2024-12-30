import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 1) {
            /** read from file and write form file */
            readFromFile(args[0]);
        } else {
            /** read form console and output in console */
            readFromArgs(args);
        }
    }

    private static void readFromFile(String fileName) {
        List<Drawable> drawableList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> stringslist = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                for (String part : parts){
                    stringslist.add(part);
                }
            }
            reader.close();

            if (stringslist.size() < 3 || stringslist.size() % 2 == 0) {
                System.out.println("Please check the arguments in the input file.");
                System.exit(1);
            }

            for (int i = 1, j = 0; i < stringslist.size(); i += 2) {
                String shape = stringslist.get(i);
                double dimension = Double.parseDouble(stringslist.get(i + 1));

                if (shape.equalsIgnoreCase("circle")) {
                    drawableList.add(new Circle("red", dimension));
                } else if (shape.equalsIgnoreCase("cube")) {
                    drawableList.add(new Cube("blue", dimension));
                }
            }

            double tArea = 0, tVolume = 0;
            for (Drawable entry : drawableList) {
                tArea += ((Shape) entry).getArea();
                if (entry instanceof ThreeDShape) {
                    tVolume += ((ThreeDShape) entry).getVolume();
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Total Area: " + tArea + "\nTotal Volume: " + tVolume);
            writer.close();
            System.out.println("DONE");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void readFromArgs(String[] args) {

        if (args.length < 3 || args.length % 2 == 0) {
            System.out.println("Please provide arguments in the following form:\n" +
                               "<array size> <object name> <length or radius>\n"   +
                               "Or just provide the input file name.");
            System.exit(1);
        }

        int size = Integer.parseInt(args[0]);
        Drawable[] drawable = new Drawable[size];

        for (int i = 1, j = 0; i < args.length; i += 2) {
            String shape = args[i];
            double dimension = Double.parseDouble(args[i + 1]);

            if (shape.equalsIgnoreCase("circle")) {
                drawable[j++] =  new Circle("red", dimension);
            } else if (shape.equalsIgnoreCase("cube")) {
                drawable[j++] =  new Cube("blue", dimension);
            }
        }

        double tArea = 0, tVolume = 0;
        for (Drawable entry : drawable) {
            tArea += ((Shape) entry).getArea();
            if (entry instanceof ThreeDShape) {
                tVolume += ((ThreeDShape) entry).getVolume();
            }
        }

        System.out.println("Total Area: " + tArea);
        System.out.println("Total Volume: " + tVolume);
    }

}
