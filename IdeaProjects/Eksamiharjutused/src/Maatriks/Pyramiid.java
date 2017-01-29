package Maatriks;

import java.util.Arrays;

/**
 * Nüüd paneme loode ja kagu nurga kokku ja loome pealtvaates püramiidi:
 *
 *  0 0 0 0 0 0 0 0 0
 *  0 1 1 1 1 1 1 1 0
 *  0 1 2 2 2 2 2 1 0
 *  0 1 2 3 3 3 2 1 0
 *  0 1 2 3 4 3 2 1 0
 *  0 1 2 3 3 3 2 1 0
 *  0 1 2 2 2 2 2 1 0
 *  0 1 1 1 1 1 1 1 0
 *  0 0 0 0 0 0 0 0 0
 *
 *  Kui tuletad meelde kuidas loode ja kagu nurka lahendada ning
 *  kuidas kirdest edelasse diagonaali joonistada, siis tead ka
 *  kuidas seda ülesannet lahendada.
 *
 *  Massiivi ei ole vaja panna, lihtsalt prindi välja. Ära üle
 *  mõtle - lahendada on võimalik kahe tsükli ja ühe if lausega.
 */
public class Pyramiid {

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i + j > 8) {
                    System.out.print(Math.min(i, j));
                }
            } else {
                System.out.print("-");
            }
            System.out.println();
        }

        int[][] pyramid = new int[9][9];

        for (int i = 0; i < pyramid.length; i++) {

            int height = pyramid.length;
            int width = pyramid[i].length;

            for (int j = 0; j < width; j++) {

                int x = width - 1 - i;
                int y = height - 1 - j;

                pyramid[i][j] = pyramid[y][x] = pyramid[y][i] = pyramid[x][j] = x;
            }
        }

        printMaatriks(pyramid);
    }

    private static void printMaatriks(int[][] laud) {
        for (int i = 0; i < laud.length; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
        System.out.println("");
    }
}
