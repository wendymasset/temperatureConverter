import java.util.Scanner;

public class Converter {
    private static Scanner scanner = new Scanner(System.in); // Scanner global

    public static void selectUnit() {
        System.out.println("Select the temperature unit you will enter:\n1.Celsius\n2.Fahrenheit");
        int option = scanner.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("**Invalid option. Try again.**\nSelect the temperature unit you will enter:\n1.Celsius\n2.Fahrenheit");
            option = scanner.nextInt();
        }
        System.out.println("Input your value");
        double value = scanner.nextDouble();
        System.out.println(getTemp(option, value));
        cont();
    }

    public static void cont() {
        System.out.println("Do you wish to input another value?\n1.Yes\n2.No");
        int option = scanner.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("**Invalid option. Try again.**\nDo you wish to input another value?\n1.Yes\n2.No");
            option = scanner.nextInt();
        }
        switch (option) {
            case 1:
                selectUnit();
                break;
            case 2:
                System.out.println("The program has ended.");
                scanner.close();
                break;
        }
    }

    public static double getTemp(int option, double value) {
        switch (option) {
            case 1:
                return ((9.0 / 5) * value) + 32;
            case 2:
                return (5.0 / 9) * (value - 32);
        }
        return 0;
    }

    public static void main(String[] args) {
        selectUnit();
    }
}
