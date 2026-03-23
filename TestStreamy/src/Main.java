import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("diamonds.csv"));
        sc.nextLine();
        ArrayList<Diamant> in = new ArrayList<>();
        while (sc.hasNextLine()){
            in.add(new Diamant(sc.nextLine()));
        }

        System.out.println(in.stream()
                .map(Diamant::getCut)
                .filter(r -> Objects.equals(r, "Fair"))
                .count());

        Double součet = in.stream()
                .filter(r -> Objects.equals(r.getCut(), "Premium"))
                .mapToDouble(Diamant::getPrice)
                .sum();
        Double pocet = (double) in.stream()
                .filter(r -> Objects.equals(r.getCut(), "Premium"))
                .count();
        System.out.println(Math.round((součet/pocet)/10)*10);

        in.stream()
                .filter(p -> p.getX() == p.getY())
                .forEach(p -> System.out.println(p.getCut() + "|" + p.getColor() + "|" + p.getPrice()));

        in.stream()
                .map(Diamant::getCut)
                .distinct()
                .forEach(System.out::println);

        Double nejCena = (double) in.stream()
                .filter(p -> Objects.equals(p.getCut(), "Fair"))
                .map(p -> p.getPrice())
                .max(Double::compareTo)
                .get();
        in.stream()
                .filter(p -> Objects.equals(p.getCut(), "Fair"))
                .map(p -> p.getPrice())
                .sorted(Comparator.reverseOrder())
                .forEach(p -> System.out.println(p / nejCena * 100 + "%"));
    }
}