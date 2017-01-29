package Algoritm;
import java.util.*;

/**
 */
public class KuulusNumber {

    public static void main(String[] args) {

        int[] inputInts = {1, 5, 3, 3, 6, 3, 7, 7}; // vastus on näha siit ära, peab olema 7


        List<Integer> inputList = new ArrayList<>();

        int counter = 0;

        for (Integer i : inputInts) {
            if (i != 3) {
                inputList.add(counter, inputInts[i]);
                counter++;
            }
        }

        Map<Integer, Integer> sortedMapList = new HashMap<>();

        for (Integer i : inputList) {
            Integer existingValue = sortedMapList.get(i);

            if (existingValue == null) {
                sortedMapList.put(i, 1);
            } else {
                sortedMapList.put(i, existingValue+1);
            }
        }


        int highestCount = 0;
        int highestCountNr = 0;

        for (Map.Entry<Integer, Integer> entry : sortedMapList.entrySet()) {
            int currentCount = entry.getValue();

            if (currentCount > highestCount) {
                highestCount = currentCount;
                highestCountNr = entry.getKey();
            }
        }


        System.out.println("Kõige rohkem esinenud number on: "+highestCountNr);

    }

}