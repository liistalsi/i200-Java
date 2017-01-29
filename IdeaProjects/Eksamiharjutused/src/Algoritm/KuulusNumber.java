import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Antud on int[] massiiv. Eemalda kõik nr 3 väärtused ja leia millist numbrit esineb kõige siis rohkem?
 * Mitte siis number, mis on kolmandal indeksil, vaid nr kolm ise.
 */
public class KuulusNumber {

    public static void main(String[] args) {

        int[] naide = {1, 5, 3, 3, 6, 3, 7, 7};

        ArrayList<Integer> newList = new ArrayList<>();

        for (int number : naide) {

            if (number != 3) {

                newList.add(number);
            }
        }

        System.out.println(newList);

        //Leiab kõige populaarsema elemendi uues massiivis

        HashMap<Integer, Integer> popularityMap = new HashMap<>();

        for (Integer item : newList) {

            Integer currentValue = popularityMap.get(item);

            if (null == currentValue) {

                popularityMap.put(item, 1);

            } else {

                int newValue = currentValue + 1;

                popularityMap.put(item, newValue);
            }
        }

        Integer maxValue = 0;
        Integer largestKey = 0;

        for (Map.Entry<Integer, Integer> entry : popularityMap.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                largestKey = key;
            }
        }

        System.out.println(largestKey);
    }
}