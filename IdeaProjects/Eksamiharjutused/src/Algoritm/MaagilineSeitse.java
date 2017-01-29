
import java.util.ArrayList;

/**
 * Antud on int[] massiiv. Korruta kõik seitsmed kahega ja leia arvude keskmine.
 */
public class MaagilineSeitse {

    public static void main(String[] args) {

        int[] naide2 = {7, 4, 324, 65, 4, 78, 7, 45, 4};

        ArrayList<Integer> multiList = new ArrayList<>();

        for (int number : naide2) {

            if (number == 7) {

                multiList.add(number * 2);

            }

            else {

                multiList.add(number);

            }
        }

        System.out.println("multi: " + multiList);

        int sum = 0;

        for (int number: multiList) {
            sum = sum + number;
        }

        System.out.println(sum);

        double average = sum / multiList.size();

        System.out.println("The average of the numbers is: " + average);


    }

}
