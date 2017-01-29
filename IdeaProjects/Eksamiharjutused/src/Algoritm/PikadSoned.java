/**
 * Antud on massiiv. Mitu sõne on massiivis keskmisest pikemad?
 */
public class PikadSoned {

    public static void main(String[] args) {


        Integer totalNumberOfLetters = 0;
        Integer averageNumberOfLetters;
        Integer wordArraySize;
        Integer greaterThanAverage = 0;

        String[] naide3 = {"kaalikas", "joonas", "maakera", "homeros", "mandel"}; // vastus on 3

        wordArraySize = naide3.length;

        for (String word : naide3) {

            Integer wordSize = word.length();

            totalNumberOfLetters = totalNumberOfLetters + wordSize;

        }

        averageNumberOfLetters = totalNumberOfLetters / wordArraySize;

        for (String word : naide3) {

            if (word.length() > averageNumberOfLetters) {

                greaterThanAverage++;
            }
        }

        System.out.println("There are that many lengthier than average words : " + greaterThanAverage);

    }

}




