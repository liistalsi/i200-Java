import java.util.ArrayList;


public class Chat extends Gitter {

    String jutuTuba;


    public Chat(String toaNimi) {

        jutuTuba = toaNimi;

    }

    static ArrayList<ArrayList> kasutajateSonumid = new ArrayList<>();

    public void sisestaSonum(String nimi, String sonum) {

        ArrayList<String> sonumiSisestus = new ArrayList<>();

        sonumiSisestus.add(nimi);
        sonumiSisestus.add(sonum);

        kasutajateSonumid.add(sonumiSisestus);

    }

    public void prindiKoikSonumidKoosKasutajanimega() {

        for (int i = 0; i < kasutajateSonumid.size(); i++) {

            System.out.println(kasutajateSonumid.get(i).get(0) + ": " + kasutajateSonumid.get(i).get(1) + " \n");

        }
    }

    public void adminKustutabSonumi(String sonum) {

        for (int i = 0; i < kasutajateSonumid.size(); i++) {
            if (sonum == kasutajateSonumid.get(i).get(1)) {

                kasutajateSonumid.remove(i);

                System.out.println("---------------\n");
            }
        }

    }

    public void prindiToaNimi() {

        System.out.println(jutuTuba);


    }
}