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
        boolean devamEdilsin = true; // Programın tekrar çalışıp çalışmayacağını tutan bir değişken

        while (devamEdilsin) { // Sonsuz bir döngü, kullanıcı çıkmak istediğinde kırılacak
            Scanner scanner = new Scanner(in);

            out.print("Mesafeyi km türünden giriniz : ");
            int mesafe = scanner.nextInt();

            out.print("Yaşınızı giriniz : ");
            int yas = scanner.nextInt();

            out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
            int yolculukTipi = scanner.nextInt();

            if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
                out.println("Hatalı Veri Girdiniz !");
            } else {
                double normalTutar = mesafe * 0.10;

                double yasIndirim = 0.0;
                if (yas < 12) {
                    yasIndirim = normalTutar * 0.50;
                } else if (yas >= 12 && yas <= 24) {
                    yasIndirim = normalTutar * 0.10;
                } else if (yas >= 65) {
                    yasIndirim = normalTutar * 0.30;
                }

                double indirimliTutar = normalTutar - yasIndirim;
                double gidisDonusIndirimi = 0.0;
                if (yolculukTipi == 2) {
                    gidisDonusIndirimi = indirimliTutar * 0.20;
                }
                double toplamTutar = (indirimliTutar - gidisDonusIndirimi) * (yolculukTipi == 1 ? 1 : 2);

                out.println("Toplam Tutar = " + toplamTutar + " TL");
            }

            out.print("Başka bir işlem yapmak istiyor musunuz? (Evet için 'e' / Hayır için 'h'): ");
            char cevap = scanner.next().charAt(0);
            if (cevap == 'h' || cevap == 'H') {
                devamEdilsin = false;
            }
        }
    }
}
