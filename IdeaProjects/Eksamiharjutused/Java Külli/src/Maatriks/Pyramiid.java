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
        int m = 9;
        int n = 9;
        char[][] matrix = new char[m][n];
        int l = matrix.length;
        //taidame maatriksi
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = numbrid(i,j,l);
            }
        }
        printMaatriks(matrix);
    }


    public static char numbrid(int i, int j, int l){

        char cifra;
        if (i == 0 || i == l-1 ||j == 0 || j == l-1){
            cifra = '0';
        }
        else if (i ==1 || i ==l-2 || j ==1 || j ==l-2){
            cifra = '1';
        }
        else  if (i==2 || i ==l-3 || j ==2 || j ==l-3){
            cifra = '2';
        }
        else if (i == 3 || i == l-4 || j ==3 || j ==l-4){
            cifra = '3';
        }
        else {
            cifra = '4';
        }
        return cifra;
    }

    private static void printMaatriks(char[][] laud) {
        for (int i = 0; i < laud.length; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
        System.out.println("");
    }
}
