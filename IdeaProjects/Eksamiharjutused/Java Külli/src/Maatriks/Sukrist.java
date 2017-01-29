/**
 * Loo 10*10 maatriks tagurpidi Tsirkuse lauamänguga. Ehk numbrid ühest sajani
 * alustavad ülevalt paremalt ja jõuavad alla paremale (või kui kaugele iganes).
 *
 * Näide 5*5 laual:
 *  5  4  3  2  1
 *  6  7  8  9 10
 * 15 14 13 12 11
 * 16 17 18 19 20
 * 25 24 23 22 21
 * 26 27 28 29 30
public class Sukrist {

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
 * Loo 10*10 maatriks tagurpidi Tsirkuse lauamänguga. Ehk numbrid ühest sajani
 * alustavad ülevalt paremalt ja jõuavad alla paremale (või kui kaugele iganes).
 *
 * Näide 5*5 laual:
 *  5  4  3  2  1
 *  6  7  8  9 10
 * 15 14 13 12 11
 * 16 17 18 19 20
 * 25 24 23 22 21
 * 26 27 28 29 30
 */
public class Sukrist {
    public static void main(String[] args) {
        int [][] maatriks = new int[10][10];

        int vastus = 1;
        for (int i = 0; i < maatriks.length; i++) {
            if (i==0 || i== 2 || i==4 || i==6 || i==8){
                for (int j = maatriks.length-1; j >= 0; j--) {
                    maatriks[i][j] = vastus;
                    vastus++;
                }
            } else {
                for (int j = 0; j <maatriks[i].length; j++) {
                    maatriks[i][j] = vastus;
                    vastus++;
                }
            }
            System.out.println(Arrays.toString(maatriks[i]));
        }
    }
}

