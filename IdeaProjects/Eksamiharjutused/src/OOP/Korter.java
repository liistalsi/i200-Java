
public class Korter extends Pidu{

    private int mahutab;

    public Korter (int mahutab) {

        this.mahutab = mahutab;

    }

    int kylalisteArv = 0;


    public void saabus(String nimi) {

        if (kylalisteArv < mahutab) {

            kylalisteArv++;
        }

    }

    public void prindiKylalisteArv() {

        System.out.println("Külalisi on hetkel: " + kylalisteArv);

    }

    public void prindiPaljuVeelMahub() {

        int veelMahub = mahutab - kylalisteArv;

        System.out.println("Veel mahub peole: " + veelMahub + " inimest");

    }

    public void lahkus(String nimi) {

        kylalisteArv--;

    }
}
