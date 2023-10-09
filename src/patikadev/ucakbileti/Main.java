package patikadev.ucakbileti;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The Main program implements an application that
 * calculates flight ticket prices according to
 * distance and conditions.
 *
 * @author Mehmet Uğur Yıldırım
 * @version 0.0.1
 * @since 2023-10-10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        out.print("Mesafeyi km turunden giriniz: ");
        int mesafe = scanner.nextInt();

        out.print("Yasinizi Giriniz: ");
        int yas = scanner.nextInt();

        out.print("Yolculuk tipini giriniz (1 => Tek Yon, 2 => Gidis Donus): ");
        int yolculukTipi = scanner.nextInt();

        scanner.close();

        if(mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)){
            out.println("Hatali Veri Girdiniz!");
        } else {
            double normalTutar = mesafe * 0.10;

            double yasIndirim = 0.0;
            if(yas < 12){
                yasIndirim = normalTutar * 0.50;
            } else if (yas >= 12 && yas <= 24){
                yasIndirim = normalTutar * 0.10;
            } else if (yas >= 65) {
                yasIndirim = normalTutar * 0.30;
            }

            double indirimliTutar = normalTutar - yasIndirim;
            double gidisDonusIndirimi = 0.0;
            if(yolculukTipi == 2){
                gidisDonusIndirimi = indirimliTutar * 0.20;
            }
            int toplamTutar = (int)(indirimliTutar - gidisDonusIndirimi) * (yolculukTipi == 1 ? 1 : 2);

            out.println("Toplam Tutar = " + toplamTutar + "TL");
        }
    }
}
