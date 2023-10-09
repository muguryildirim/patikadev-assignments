package patikadev.primenumber;

import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        out.print("Sayı Giriniz: ");
        int sayi = scanner.nextInt();
        scanner.close();
        if(sayi <= 1){
            out.println(sayi + " sayısı ASAL değildir !");
        } else if (asalMi(sayi, 2)){
            out.println(sayi + " sayısı ASALDIR !");
        } else {
            out.println(sayi + " sayısı ASAL değildir !");
        }
    }
    public static boolean asalMi(int sayi, int bolen){
        if((Math.pow(bolen,2) > sayi)){
            return true;
        }
        if(sayi % bolen == 0){
            return false;
        }
        return asalMi(sayi, bolen + 1);
    }
}
