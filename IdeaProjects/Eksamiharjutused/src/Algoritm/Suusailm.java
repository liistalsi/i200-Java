import java.util.ArrayList;

/**
 * Antud on kaks massiivi õhu temperatuuridega. Arvuta mõlema puhul mitu positiivset temperatuuri
 * on massiivis rohkem kui negatiivseid.
 */
public class Suusailm {
    public static void main(String[] args) {

        int[] kraadid1 = {11, 10, 5, 1, 3, -2, -6, 2, -13, -24, -9, 0};
        int[] kraadid2 = {-23, -25, -22, -18, -15, -19, -13};

        ArrayList<Integer> positiveValues = new ArrayList<>();
        ArrayList<Integer> negativeValues = new ArrayList<>();

        ArrayList<Integer> positiveValues2 = new ArrayList<>();
        ArrayList<Integer> negativeValues2 = new ArrayList<>();

        for (int number : kraadid1) {

            if (number >= 0) {

                positiveValues.add(number);

            }
            else {

                negativeValues.add(number);

            }

        }

        System.out.println(positiveValues);
        System.out.println(negativeValues);

        int mituRohkem = positiveValues.size() - negativeValues.size();

        System.out.println("Massiivis on " + mituRohkem + " positiivset kraadi rohkem");

        for (int number : kraadid2) {

            if (number >= 0) {

                positiveValues2.add(number);

            }
            else {

                negativeValues2.add(number);

            }

        }

        System.out.println(positiveValues2);
        System.out.println(negativeValues2);

        int mituRohkem2 = positiveValues2.size() - negativeValues2.size();

        if (mituRohkem2 < 0) {

            System.out.println("Massiivis on " + "0" + " positiivset kraadi rohkem");

        }
        else {

            System.out.println("Massiivis on " + mituRohkem2 + " positiivset kraadi rohkem");

        }

    }
}
