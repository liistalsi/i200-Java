import java.util.ArrayList;

public class Sonaraamat extends Raamatukogu {

    String raamatuKeel;

    public Sonaraamat (String raamatuKeel) {

        this.raamatuKeel = raamatuKeel;
    }

    ArrayList<String> koikSonad = new ArrayList<>();


    public void sisestaSona(String uusSona) {

        koikSonad.add(uusSona);
    }


    public String[] otsiEsimeseTaheJargi(String taht) {

        String[] tulemus = new String[2];
        int a = 0;

        for (int i = 0; i < koikSonad.size(); i++) {

            if (koikSonad.get(i).startsWith(taht)) {

                tulemus[a] = koikSonad.get(i);
                a++;
            }
        }
        return tulemus;
    }


    public void eemaldaSona(String uusSona) {

        for (int i = 0; i < koikSonad.size(); i++) {
            if (uusSona == koikSonad.get(i)) {
                koikSonad.remove(i);
            }
        }
    }

    public void misKeelesRaamatOn() {

        System.out.println(raamatuKeel);

    }
}
