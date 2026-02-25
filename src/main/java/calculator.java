import java.util.Scanner;
import java.util.Locale;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter kilometers: ");
        double kilometers;
        if (scanner.hasNextDouble()) {
            kilometers = scanner.nextDouble();
        } else {
            String bad = scanner.next();
            System.out.println("Invalid input for kilometers: '" + bad + "'");
            scanner.close();
            return;
        }

        System.out.print("Enter hours: ");
        double hours;
        if (scanner.hasNextDouble()) {
            hours = scanner.nextDouble();
        } else {
            String bad = scanner.next();
            System.out.println("Invalid input for hours: '" + bad + "'");
            scanner.close();
            return;
        }

        scanner.close();

        if (hours == 0) {
            System.out.println("Hours cannot be zero (would divide by zero).");
            return;
        }

        double speed = computeSpeed(kilometers, hours);

        String speedStr = formatNumber(speed);

        System.out.println(speedStr + " km/h");
    }

    // Public API for testing
    public static double computeSpeed(double kilometers, double hours) {
        if (hours == 0) {
            throw new IllegalArgumentException("hours cannot be zero");
        }
        return kilometers / hours;
    }

    // Made public for tests
    public static String formatNumber(double v) {
        if (Math.abs(v - Math.round(v)) < 1e-9) {
            return String.valueOf(Math.round(v));
        } else {
            return String.format(Locale.US, "%.2f", v);
        }
    }
}
