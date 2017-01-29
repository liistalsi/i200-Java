/**
 * Loo 10*10 maatriks tsirkuse lauamänguga. Ehk numbrid ühest sajani
 * alustavad alt vasakult ja jõuavad üles vasakule.
 *
 * Näide 5*5 laual:
 * 30 29 28 27 26
 * 21 22 23 24 25
 * 20 19 18 17 16
 * 11 12 13 14 15
 * 10 9  8  7  6
 * 1  2  3  4  5
public class Tsirkus {

    // Lihtsalt abiline meetod, et maatriksit välja printida
    private static void printMaatriks(int[][] laud) {
        for (int i = 0; i < laud.length; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
        System.out.println("");
    }
}
 */

package Maatriks;

import java.util.Arrays;

/**
 * Loo 10*10 maatriks tsirkuse lauamänguga. Ehk numbrid ühest sajani
 * alustavad alt vasakult ja jõuavad üles vasakule.
 *
 * Näide 5*5 laual:
 * 30 29 28 27 26
 * 21 22 23 24 25
 * 20 19 18 17 16
 * 11 12 13 14 15
 * 10 9  8  7  6
 * 1  2  3  4  5
 */
public class Tsirkus {
    public static void main(String[] args) {
        int[][] maatriks = new int[10][10];
        int vastus = 100;
        for (int i = 0; i < maatriks.length; i++) {
            if (i%2!=0) {

                for (int j = maatriks[i].length-1; j >= 0; j--) {
                    maatriks[i][j]= vastus;
                    vastus--;
                }
            } else {
                for (int j = 0; j < maatriks[i].length; j++) {
                    maatriks[i][j]= vastus;
                    vastus--;
                }
            }
            System.out.println(Arrays.toString(maatriks[i]));
        }
    }
}
