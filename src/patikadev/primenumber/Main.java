package patikadev.primenumber;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The Main program implements an application that
 * uses the Recursive method to find out whether the
 * number received from the user is a "Prime" number.
 * @author Mehmet Uğur Yıldırım
 * @version 0.0.1
 * @since 2023-10-10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        while (true) {
            out.print("Sayı Giriniz (Programı sonlandırmak için 'q' girin): ");
            String input = scanner.next();

            if (input.equals("q")) {
                out.println("Program sonlandırıldı.");
                break;
            }
            try {
                int sayi = Integer.parseInt(input);

                if (sayi <= 1) {
                    out.println(sayi + " sayısı ASAL değildir !");
                } else if (asalMi(sayi, 2)) {
                    out.println(sayi + " sayısı ASALDIR !");
                } else {
                    out.println(sayi + " sayısı ASAL değildir !");
                }
            } catch (NumberFormatException e) {
                out.println("Geçersiz giriş. Bir sayı girin veya 'q' ile çıkın.");
            }
        }
        scanner.close();
    }
    public static boolean asalMi(int sayi, int bolen) {
        if ((Math.pow(bolen, 2) > sayi)) {
            return true;
        }
        if (sayi % bolen == 0) {
            return false;
        }
        return asalMi(sayi, bolen + 1);
    }
}
