package Algoritm;

import java.util.ArrayList;

/**
 * Antud on int[] massiiv. Korruta kõik seitsmed kahega ja leia arvude keskmine.
 */
public class MaagilineSeitse {

    public static void main(String[] args) {

        int[] naide = {7, 4, 324, 65, 4, 78, 7, 45, 4};
        ArrayList <Integer> kahekordsedSeitsmed = new ArrayList<>();

        for (int i = 0; i < naide.length; i++) {
            if (naide[i] == 7) {
                int seitseKordaKaks = naide[i]*2;
                kahekordsedSeitsmed.add(seitseKordaKaks);
            } else {
                kahekordsedSeitsmed.add(naide[i]);
            }
        }
        System.out.println(kahekordsedSeitsmed);

        int l = 0;
        double summa = 0;

        while (l < kahekordsedSeitsmed.size()) {
            summa = summa + kahekordsedSeitsmed.get(l);
            l++;
        }
        System.out.println(summa);

        double keskmine = summa/kahekordsedSeitsmed.size();
        System.out.println(keskmine);
    }
}
