import java.util.Arrays;

/**
 * Loo 9*9 suurune maatriks, millele tekib kagu suunaline nurkade muster, nagu näites.
 * Tundub raske? Sul tuleb lihtsalt veeru ja rea indeksi seos leida.
 *
 * Näide
 * 9 8 7 6 5 4 3 2 1
 * 8 8 7 6 5 4 3 2 1
 * 7 7 7 6 5 4 3 2 1
 * 6 6 6 6 5 4 3 2 1
 * 5 5 5 5 5 4 3 2 1
 * 4 4 4 4 4 4 3 2 1
 * 3 3 3 3 3 3 3 2 1
 * 2 2 2 2 2 2 2 2 1
 * 1 1 1 1 1 1 1 1 1
 *
 * Tundub raske? Leia seoseid rea ja veeru indeksi numbritega.
 */
public class KaguNurk {

    public static void main(String[] args) {

        int[][] fancyMatrix = new int[9][9];

        for (int i = 0; i < fancyMatrix.length; i++) {

            for (int j = 0; j < fancyMatrix[i].length; j++) {

                if (i > j) {
                    fancyMatrix[i][j] = fancyMatrix.length - i;

                } else {
                    fancyMatrix[i][j] = fancyMatrix.length - j;
                }
            }
        }
        printMaatriks(fancyMatrix);
    }


        // Lihtsalt abiline meetod, et maatriksit välja printida

    private static void printMaatriks(int[][] laud) {
        for (int i = 0; i < laud.length; i++) {
            System.out.println(Arrays.toString(laud[i]));
        }
        System.out.println("");
    }

}
