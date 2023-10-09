package patikadev.bmi;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The Main program implements an application that
 * simply displays person's BMI (Body Mass Index).
 *
 * @author Mehmet Ugur Yildirim - muyildirim
 * @version 0.0.1
 * @since 2023-10-10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        out.print("Lutfen Kilonuzu Giriniz -kg : ");
        double kilo = scanner.nextDouble();

        out.print("Lutfen Boyunuzu Giriniz -m : ");
        double boy = scanner.nextDouble();

        double kitleIndex = kilo / (Math.pow(boy,2));

        out.println("Vucut Kitle Indexiniz : " + kitleIndex);

    }
}
