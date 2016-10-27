package main;

import java.util.Scanner;

/**
 * Created by ltalsi on 23.10.2016.
 */
public class Esimene {
    public static void main(String[] args) {
        Scanner klaviatuur = new Scanner(System.in);

        System.out.println("Tere, mis on sinu asukoht (Linn)?");
        String asukoht = klaviatuur.nextLine();
        System.out.println("Ja mis on sind huvitav kellaaeg asukohas " + asukoht + "?");
        int kellaaeg = klaviatuur.nextInt();
        System.out.println("Ning milline oleks Sinule huvipakkuv sihtkoht (Linn)?");
        String sihtkoht = klaviatuur.next();

        System.out.println("Sellisel juhul, kui teie asukoht on " + asukoht + ", ja kell on seal " + kellaaeg + ". Siis samal ajal on " + sihtkoht);
    }
}
