package Maatriks;

import java.util.Arrays;
/**

 * Loo 9*9 suurune maatriks, millele tekib loode suunaline nurkade muster, nagu näites.
 * 1 1 1 1 1 1 1 1 1
 * 1 2 2 2 2 2 2 2 2
 * 1 2 3 3 3 3 3 3 3
 * 1 2 3 4 4 4 4 4 4
 * 1 2 3 4 5 5 5 5 5
 * 1 2 3 4 5 6 6 6 6
 * 1 2 3 4 5 6 7 7 7
 * 1 2 3 4 5 6 7 8 8
 * 1 2 3 4 5 6 7 8 9

*/
public class LoodeNurk {

    public static void main(String[] args) {
        int [][] maatriks = new int[9][9];
        int value;
        for (int rida = 0; rida < maatriks.length; rida++) {
            value = 1;
            for (int veerg = 0; veerg < maatriks[rida].length; veerg++) {
                maatriks[rida][veerg] = value;
                if(value<=rida)
                    value++;
            }
        }
        printMaatriks(maatriks);
    }
    private static void printMaatriks(int[][] laud) {
        for (int i = 0; i < laud.length; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
        System.out.println("");
    }

}