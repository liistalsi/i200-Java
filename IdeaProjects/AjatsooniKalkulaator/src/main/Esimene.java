package main;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by ltalsi on 23.10.2016.
 */
public class Esimene {
    public static void main(String[] args) {

        HashMap<String, Integer> linnad = new HashMap<>();

        linnad.put("Tallinn", 2);
        linnad.put("London", 0);
        linnad.put("New York", 5);
        linnad.put("Sinapur", 8);
        linnad.put("Helsingi", 2);
        linnad.put("Tallinn", 2);
        linnad.put("Dublin", 0);
        linnad.put("Lisbon", 0);
        linnad.put("Hong Kong", 8);
        linnad.put("Beijing", 8);
        linnad.put("Miami", 5);
        linnad.put("Boston", 5);

        Scanner klaviatuur = new Scanner(System.in);

        System.out.println("Tere, mis on sinu asukoht (Linn)?");
        String asukoht = klaviatuur.nextLine();
        System.out.println("Ja mis on sind huvitav kellaaeg asukohas " + asukoht + "?");
        int kellaaeg = klaviatuur.nextInt();
        System.out.println("Ning milline oleks Sinule huvipakkuv sihtkoht (Linn)?");
        String sihtkoht = klaviatuur.next();

        int sihtkohaaeg = kellaaeg - 2;



        if(asukoht.equals("Tallinn") && sihtkoht.equals("London")) {
            System.out.println("Siis võtame kellaajast paar tundi maha ja saame " + sihtkohaaeg);
        } else {
            System.out.println("Sellist linna pole olemas!");
        }

        System.out.println("Sellisel juhul, kui teie asukoht on " + asukoht + ", ja kell on seal " + kellaaeg + ". Siis samal ajal on " + sihtkoht + " kell alles " + sihtkohaaeg);
    }
}
