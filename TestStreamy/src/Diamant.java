import java.util.Objects;

public class Diamant {
    private final double carat;
    private String cut;
    private final String color;
    private final String clarity;
    private final double depth;
    private final double table;
    private final double price;
    private final double X;
    private final double Y;
    private final double Z;

    public Diamant(String line) {
        String[] split = line.split(",");

        carat = Double.parseDouble(split[1]);
        cut = split[2].trim();
        color = split[3];
        clarity = split[4];
        depth = Double.parseDouble(split[5]);
        table = Double.parseDouble(split[6]);
        price = Double.parseDouble(split[7]);
        X = Double.parseDouble(split[8]);
        Y = Double.parseDouble(split[9]);
        Z = Double.parseDouble(split[10]);
    }


    public String getCut() {
        return cut;
    }

    public double getPrice() {
        return price;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public String getColor() {
        return color;
    }
}
