package patikadev.maxmin;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * The Main program implements an application that
 * finds the largest and smallest numbers among N
 * counting numbers entered from the keyboard and
 * writes these numbers to the screen.
 *
 * @author Mehmet Uğur Yıldırım
 * @version 0.0.1
 * @since 2023-10-10
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        out.print("Kaç tane sayı gireceksiniz: ");
        int n = scanner.nextInt();

        if(n <= 0){
            out.println("Lütfen pozitif bir sayı girin! ");
            return;
        }

        int enBuyuk = Integer.MIN_VALUE;
        int enKucuk = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            out.print((i + 1) + ". Sayıyı giriniz: ");
            int sayi = scanner.nextInt();

            enBuyuk = Math.max(enBuyuk, sayi);
            enKucuk = Math.min(enKucuk, sayi);

        }
        out.println("En büyük sayı: " + enBuyuk);
        out.println("En küçük sayı: " + enKucuk);

        scanner.close();
    }
}
