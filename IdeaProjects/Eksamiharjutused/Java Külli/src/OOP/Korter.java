package OOP;


import java.util.Arrays;

public class Korter {
    private int mahutab;
    private int counter = 0;
    private String[] kylalised;

    public Korter(int mahutab) {
        this.mahutab = mahutab;
        kylalised = new String[mahutab];
    }

    public void saabus(String str) {
        for (int i = 0; i < kylalised.length; i++) {
            if (kylalised[i] == null) {
                kylalised[i] = str;
                counter++;
                return;
            }
        }
    }

    public void lahkus(String str) {
        for (int i = 0; i < kylalised.length; i++) {
            if (kylalised[i].equals(str)) {
                kylalised[i] = null;
                counter--;
                return;
            }
        }
    }

    public void prindiPaljuVeelMahub() {
        System.out.println("Veel mahub " + (mahutab - counter) + " külalist");
    }

    public void prindiKylalisteArv() {
        System.out.println("Külaliste arv on: " + counter);
        System.out.println("Massiiv: " + Arrays.toString(kylalised));
    }
}
