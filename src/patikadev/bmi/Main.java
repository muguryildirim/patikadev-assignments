package patikadev.bmi;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The Main program implements an application that
 * simply displays a person's BMI (Body Mass Index).
 *
 * @author Mehmet Uğur Yıldırım
 * @version 0.0.1
 * @since 2023-10-10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        out.print("Lütfen boyunuzu (metre cinsinde) giriniz : ");
        double boy = scanner.nextDouble();

        out.print("Lütfen kilonuzu giriniz : ");
        double kilo = scanner.nextDouble();

        double kitleIndex = vkiHesapla(boy, kilo);

        out.println("Vücut Kitle İndeksiniz : " + kitleIndex);
    }

    public static double vkiHesapla(double boy, double kilo){
        if (boy <= 0 || kilo <= 0){
            out.println("Hatalı giriş. Boy ve Kilo değerleri pozitif değerler olmalı.");
            return -1;
        }
        return kilo / (Math.pow(boy,2));
    }
}
